# so this binary just runs some algo on the input 3 times. and expects it to be something.
# im too lazy to try to find how to reverse this so i'll let z3 magically solve it.

from z3 import BitVec, Solver, sat
from ctypes import c_uint32

def algo(buf: list):
    result = buf.copy()
    local_18 = 85
    local_1c = 51
    local_20 = 15
    local_21 = 97
    
    for _ in range(3):
        for j in range(len(buf)):
            uVar1 = (j % 0xff >> 1 & local_18) + (j % 0xff & local_18)
            uVar1 = (uVar1 >> 2 & local_1c) + (local_1c & uVar1)
            iVar2 = (uVar1 >> 4 & local_20) + (result[j] - local_21) + (local_20 & uVar1)
            result[j] = (local_21 + iVar2 + (iVar2 / 0x1a) * -0x1a)
    return result  
   
def main():
    expected = "lxpyrvmgduiprervmoqkvfqrblqpvqueeuzmpqgycirxthsjaw"
    buf = [BitVec('buf_%d' % i, 8) for i in range(len(expected))]
    changed_buf = algo(buf)
    s = Solver()
    
    for i in buf: # make sure the password is printable
        s.add(i >= ord('!'))
        s.add(i <= ord('~'))
    
    for i, j in zip(expected, changed_buf):
        s.add(ord(i) == j) 
        

    if s.check() == sat:
        model = s.model()
        result = ""
        for i in buf:
            result += chr(model[i].as_long())
        print(result)
    else:
        print("z3 decided this is unsolvable :')")
    
if __name__ == "__main__":
    main()
