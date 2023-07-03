#!/bin/python3
from sys import argv

#this vmwhere things are flipping awesome man!!!

def twos_comp(val, bits):
    """compute the 2's complement of int value val"""
    
    #borrowed this from https://stackoverflow.com/a/9147327

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
                result += "return 0"
                i += 1
            case 1:
                result += "pop r\n    \t[sp-1] += r" ## all of the following ones with pop r work the following way:
                ## two things are pushed to stack, one is popped and operated to the first one.
                ## if stack was: 1, 22, 28
                ## it'll become: 1, 50
                i+=1
            case 4:
                result += 'pop r\n    \t[sp-1] |= r'
                i+=1
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
                if program[i + 2] >= 1 and program[i+2] <= 7:
                    ops = [0,'+',0,0,'|','^',0, '>>']
                    result += '[sp-1] ' + ops[program[i + 2]] + '= ' + hex(program[i+1])
                    i+= 3
                else:
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
                result += 'pop garbage' # subtracts 1 from sp
                i+=1
            case 0xf:
                result += 'push [sp - 1]' # pushes last pushed thing again
                i+=1
            case 0x10:
                result += "reverse_stack " + hex(program[i+1]) # reverses last n bytes on stack. 0b100 turns to 0b001 if n= 3
                i+=2
            case 0x11:
                result += 'split_last_pushed_LSB' # takes last pushed byte and splits it to 8 bits
                #if stack was like that: 1,1, 0b10101111
                #it'll become 1, 1, 1, 1, 1, 1, 0,1,0, 1
                i+=1
            case _:
                print("File has unknown opcode. Killing myself.")
                break
        result += '\n'
        
    return result


with open(argv[1],"rb") as f:
    program = f.read(20000) #READTHEMALL


print (disass(program))