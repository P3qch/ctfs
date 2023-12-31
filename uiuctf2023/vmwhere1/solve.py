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