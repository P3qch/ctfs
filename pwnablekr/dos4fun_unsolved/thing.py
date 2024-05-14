from z3 import *

nums = [BitVec(f'n{i}', 16)  for i in range(25)]
nums_enc = [0 for _ in range(25)]
for i in range(25):
    nums_enc[i] = nums[i] ^ 0xffff

s = Solver()
for i in range(24):
    s.add(nums_enc[i] < nums_enc[i+1])

s.add(nums_enc[24] < nums_enc[0])

ch = s.check()

if ch == sat:
    for i in nums:
        n = s.model().eval(i).as_long()
        print(f"{n = } {n ^ 0xffff}")
