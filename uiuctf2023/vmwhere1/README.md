# VMWhere1 - uiuctf 2023
## writeup by p3qch
So i'm not sure how other people solved this, but i went completly friggin overkill with this one :D
We get two binaries: chal which is an ELF and program which is a program in a madeup language.
when we open chal in ghidra we could find main:
```c
undefined8 main(int param_1,undefined8 *param_2)

{
  undefined8 uVar1;
  long in_FS_OFFSET;
  undefined4 program_text;
  int local_1c;
  long program_length;
  long local_10;
  
  local_10 = *(long *)(in_FS_OFFSET + 0x28);
  if (param_1 < 2) {
    printf("Usage: %s <program>\n",*param_2);
    uVar1 = 1;
  }
  else {
    program_length = open_prog(param_2[1],&program_text);
    if (program_length == 0) {
      printf("Failed to read program %s\n",param_2[1]);
      uVar1 = 2;
    }
    else {
      local_1c = interpret(program_length,program_text);
      if (local_1c == 0) {
        uVar1 = 0;
      }
      else {
        uVar1 = 3;
      }
    }
  }
  if (local_10 != *(long *)(in_FS_OFFSET + 0x28)) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return uVar1;
}
```
We could see it just opens a file, and sends it to the interpret function, (i already added the names, the binary was stripped so you couldn't see it instantly)
Let's take a look at the interpret func:
```c
undefined8 interpret(byte *program_code,int program_length)
{
  byte bVar1;
  byte bVar2;
  int iVar3;
  byte *pbVar4;
  uint local_24;
  byte *current_instruction;
  byte *stack_ptr;
  byte *ip;
  
  pbVar4 = (byte *)malloc(0x1000);
  current_instruction = program_code;
  stack_ptr = pbVar4;
  while( true ) {
    if ((current_instruction < program_code) ||
       (program_code + program_length <= current_instruction)) {
      printf("Program terminated unexpectedly. Last instruction: 0x%04lx\n",
             (long)current_instruction - (long)program_code);
      return 1;
    }
    ip = current_instruction + 1;
    switch(*current_instruction) {
    case 0:
      return 0;
    case 1:
      stack_ptr[-2] = stack_ptr[-2] + stack_ptr[-1];
      stack_ptr = stack_ptr + -1;
      current_instruction = ip;
      break;
    case 2:
      stack_ptr[-2] = stack_ptr[-2] - stack_ptr[-1];
      stack_ptr = stack_ptr + -1;
      current_instruction = ip;
      break;
    case 3:
      stack_ptr[-2] = stack_ptr[-2] & stack_ptr[-1];
      stack_ptr = stack_ptr + -1;
      current_instruction = ip;
      break;
    case 4:
      stack_ptr[-2] = stack_ptr[-2] | stack_ptr[-1];
      stack_ptr = stack_ptr + -1;
      current_instruction = ip;
      break;
    case 5:
      stack_ptr[-2] = stack_ptr[-2] ^ stack_ptr[-1];
      stack_ptr = stack_ptr + -1;
      current_instruction = ip;
      break;
    case 6:
      stack_ptr[-2] = stack_ptr[-2] << (stack_ptr[-1] & 0x1f);
      stack_ptr = stack_ptr + -1;
      current_instruction = ip;
      break;
    case 7:
      stack_ptr[-2] = (byte)((int)(uint)stack_ptr[-2] >> (stack_ptr[-1] & 0x1f));
      stack_ptr = stack_ptr + -1;
      current_instruction = ip;
      break;
    case 8:
      iVar3 = getchar();
      *stack_ptr = (byte)iVar3;
      stack_ptr = stack_ptr + 1;
      current_instruction = ip;
      break;
    case 9:
      stack_ptr = stack_ptr + -1;
      putchar((uint)*stack_ptr);
      current_instruction = ip;
      break;
    case 10:
      *stack_ptr = *ip;
      stack_ptr = stack_ptr + 1;
      current_instruction = current_instruction + 2;
      break;
    case 0xb:
      if ((char)stack_ptr[-1] < '\0') {
        ip = ip + CONCAT11(*ip,current_instruction[2]);
      }
      current_instruction = ip;
      current_instruction = current_instruction + 2;
      break;
    case 0xc:
      if (stack_ptr[-1] == 0) {
        ip = ip + CONCAT11(*ip,current_instruction[2]);
      }
      current_instruction = ip;
      current_instruction = current_instruction + 2;
      break;
    case 0xd:
      current_instruction = ip + (long)CONCAT11(*ip,current_instruction[2]) + 2;
      break;
    case 0xe:
      stack_ptr = stack_ptr + -1;
      current_instruction = ip;
      break;
    case 0xf:
      *stack_ptr = stack_ptr[-1];
      stack_ptr = stack_ptr + 1;
      current_instruction = ip;
      break;
    case 0x10:
      current_instruction = current_instruction + 2;
      bVar1 = *ip;
      if ((long)stack_ptr - (long)pbVar4 < (long)(ulong)bVar1) {
        printf("Stack underflow in reverse at 0x%04lx\n",
               (long)current_instruction - (long)program_code);
      }
      for (local_24 = 0; (int)local_24 < (int)(uint)(bVar1 >> 1); local_24 = local_24 + 1) {
        bVar2 = stack_ptr[(int)(local_24 - bVar1)];
        stack_ptr[(int)(local_24 - bVar1)] = stack_ptr[(int)~local_24];
        stack_ptr[(int)~local_24] = bVar2;
      }
      break;
    default:
      printf("Unknown opcode: 0x%02x at 0x%04lx\n",(ulong)*current_instruction,
             (long)current_instruction - (long)program_code);
      return 1;
    case 0x28:
      FUN_00101370(program_code,pbVar4,stack_ptr,(long)ip - (long)program_code);
      current_instruction = ip;
    }
    if (stack_ptr < pbVar4) break;
    if (pbVar4 + 0x1000 < stack_ptr) {
      printf("Stack overflow at 0x%04lx\n",(long)current_instruction - (long)program_code);
      return 1;
    }
  }
  printf("Stack underflow at 0x%04lx\n",(long)current_instruction - (long)program_code);
  return 1;
}
```
So we see that it just runs over the code, and each opcode does it's own crap, AND THAT IS where i went overkill.
I decided to make a disassembler for this madeup language, using the interpret functions, here it is:
```py
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
                result += 'jmp SHORT ' + hex(twos_comp(addr, 16) + 3) # jmps 
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
```
I added each instruction by trial and error, appearently the given program didn't use half of the available opcodes :D

let's have a look at the "disassemly"
```
$ ./disass.py ./program > output
```
When we open output we see that untill 0x71 we're printing the message, and then the actual fun begins.
```
0x74:	push 0x0 #
0x76:	push getchar()
0x77:	push [sp - 1]
0x78:	push 0x4 # 
0x7a:	pop r
    	[sp-1] >>= r & 0x1f
0x7b:	pop r
    	[sp-1] ^= r
0x7c:	pop r
    	[sp-1] ^= r
0x7d:	push [sp - 1]
0x7e:	push 0x72 # 'r'
0x80:	pop r
    	[sp-1] ^= r
0x81:	jz SHORT 0x6
0x84:	jmp SHORT 0x410
0x87:	pop garbage
```
We push a zero and we do the following thing on the input: 
`last_key ^ (x ^ (x >> 4)) ^ key` where last_key is the 0, x is the user inputted character, and key is the thing we push at 0x7e, and we check if this expression returns a 0, if doesn't we jump to the place that prints that the input was not the correct password. 
We see that this thing continues multiple times, with the keys changing. Using a little help from z3 i assembled the following python script:
```py
from z3 import *

def encrypt( last_key, key):
    s = Solver()
    x= BitVec('x', 8)
    s.add(last_key ^ (x ^ (x >> 4)) ^ key == 0)
    s.add(x >= ord('!'))
    s.add (x <= ord('~'))
    if s.check() == sat:
        result = s.model()[x].as_long()
        return result
    else:
        return -1, -1

keys = [0,0x72, 0x1d, 0x6f, 0xa, 0x79, 0x19,0x65, 0x2, 0x77,
    0x47,0x1d, 0x63, 0x50, 0x22, 0x78, 0x4f,
    0x15, 0x60, 0x50, 0x37, 0x5d, 0x7,0x76, 0x1d,
    0x47,0x37, 0x59, 0x69, 0x1c, 0x2c, 0x76,
    0x5c, 0x3d, 0x4a, 0x39, 0x63, 0x2, 0x32,
    0x5a, 0x6a, 0x1f, 0x28, 0x5b, 0x6b, 0x9, 0x53,
    0x20, 0x4e, 0x7c, 0x8, 0x52, 0x32, 0, 0x37,
    0x56, 0x7d, 0x7,]
flag = ""
for i in range(1, len(keys)):
    val = encrypt(keys[i-1], keys[i])
    flag += chr(val)
print(flag)
```
Let's try it:
```
$ python3 ./solve.py
uiuctf{ar3_y0u_4_r3al_vm_wh3r3_(gpt_g3n3r4t3d_th1s_f14g)}
```
And we get the flag! This challange was fun!