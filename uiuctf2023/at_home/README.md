# At Home - uiuctf 2023
## writeup by p3qch :D

we are given two files:
chal.txt:
```
e = 359050389152821553416139581503505347057925208560451864426634100333116560422313639260283981496824920089789497818520105189684311823250795520058111763310428202654439351922361722731557743640799254622423104811120692862884666323623693713
n = 26866112476805004406608209986673337296216833710860089901238432952384811714684404001885354052039112340209557226256650661186843726925958125334974412111471244462419577294051744141817411512295364953687829707132828973068538495834511391553765427956458757286710053986810998890293154443240352924460801124219510584689
c = 67743374462448582107440168513687520434594529331821740737396116407928111043815084665002104196754020530469360539253323738935708414363005373458782041955450278954348306401542374309788938720659206881893349940765268153223129964864641817170395527170138553388816095842842667443210645457879043383345869
```

chal.py:
```py
from Crypto.Util.number import getRandomNBitInteger

flag = int.from_bytes(b"uiuctf{******************}", "big")

a = getRandomNBitInteger(256)
b = getRandomNBitInteger(256)
a_ = getRandomNBitInteger(256)
b_ = getRandomNBitInteger(256)

M = a * b - 1
e = a_ * M + a
d = b_ * M + b

n = (e * d - 1) // M

c = (flag * e) % n

print(f"{e = }")
print(f"{n = }")
print(f"{c = }")
```

so in chal.txt we're given three variables, e,n and c, and now when we look at chal.py, we could see the following lines: 
```py
flag = int.from_bytes(b"uiuctf{******************}", "big")
[...]
c = (flag * e) % n
```
so the flag starts with `uiuctf{`, then it got 18 unknown printable characters (cuz it's a flag :D), and then it ends with `}`.
In addition we know that `c = (flag * e) % n`, and because we know e, n and c, it's an equation with one unknown.
BUT they don't teach you in high-school how to solve stuff like that, therefore i'll just feed all of this info to z3, and pray that he'll succeed to solve the equation.

```py
from z3 import *

def int_from_arr(arr):
    known_sum = 0
    var_sum = 0
    arr= arr[::-1]

    for i, val in enumerate(arr):
        if isinstance(val, int):
            known_sum += val * 0x100**i
        else:
            var_sum+= val * 0x100**i

    arr = arr[::-1]
    print(hex(known_sum))
    return known_sum + var_sum

def main():
    s = Solver()

    e = 359050389152821553416139581503505347057925208560451864426634100333116560422313639260283981496824920089789497818520105189684311823250795520058111763310428202654439351922361722731557743640799254622423104811120692862884666323623693713
    n = 26866112476805004406608209986673337296216833710860089901238432952384811714684404001885354052039112340209557226256650661186843726925958125334974412111471244462419577294051744141817411512295364953687829707132828973068538495834511391553765427956458757286710053986810998890293154443240352924460801124219510584689
    c = 67743374462448582107440168513687520434594529331821740737396116407928111043815084665002104196754020530469360539253323738935708414363005373458782041955450278954348306401542374309788938720659206881893349940765268153223129964864641817170395527170138553388816095842842667443210645457879043383345869

    """
    initialize flag, knowing that it 
    matches the following format: 
    "uiuctf{******************}"
    where * is unknown
    """

    flag = [ord(i) for i in "uiuctf{"]
    
    for i in range(18):
        char = BitVec('flag_'+str(i), 256)
        s.add(char >= ord('!')) # each character of flag is printable
        s.add(char <= ord('~'))
        flag.append(char)

    flag.append(ord('}'))

    # from chal.py we see `c = (flag * e) % n` which is an equation with one unknown (flag). Let z3 solve it for us
    s.add(c == (int_from_arr(flag)*e)%n)


    if s.check() == sat:
        for i in range(len(flag)):
            if isinstance(flag[i], int):
                print(chr(flag[i]), end='')
            else:
                print(chr(s.model()[flag[i]].as_long()), end='')
    else:
        print("something went very wrong, and the thing didn't even get solved. Sad banana")

if __name__ == "__main__":
    main()
```