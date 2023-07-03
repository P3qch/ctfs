#!/bin/python3
from sys import argv

def twos_comp(val, bits):
    """compute the 2's complement of int value val"""
    if (val & (1 << (bits - 1))) != 0: # if sign bit is set e.g., 8bit: 128-255
        val = val - (1 << bits)        # compute negative value
    return val                         # return positive value as is

def disass (program):
    result = ""
    i=0
    
    while i < len(program):
        result += hex(i) + ':\t'
        match program[i]:
            case 0:
                break
            case 5:
                result += 'pop r\n    \t[sp-1] ^= r'
                i+=1
            case 7:
                result += 'pop r\n    \t[sp-1] >>= r & 0x1f'
                i+=1
            case 8:
                result += 'push getchar()'
                i+=1
            case 9:
                result += 'pop r\n    \tputchar(r)'
                i+=1
            case 0xa:
                result += 'push ' + hex(program[i+1]) + ' # \'' + chr(program[i+1]) + '\''
                i+=2
            case 0xc:
                addr = (program[i+1] << 8) + program[i+2]
                result += 'jz SHORT ' + hex(twos_comp(addr, 16) + 3) # jmps if top of stack is 0
                i += 3
            case 0xd:
                addr = (program[i+1] << 8) + program[i+2]
                result += 'jmp SHORT ' + hex(twos_comp(addr, 16) + 3) # jmps if top of stack is 0
                i += 3
            case 0xe:
                result += 'pop garbage'
                i+=1
            case 0xf:
                result += 'push [sp - 1]'
                i+=1
            case _:
                print("File has unknown opcode. Killing myself.")
                break
        result += '\n'
        
    return result


with open(argv[1],"rb") as f:
    program = f.read(2047)


print (disass(program))