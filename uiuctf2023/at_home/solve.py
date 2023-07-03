from z3 import *

def int_from_arr(arr):
    result = 0

    arr= arr[::-1]

    for i, val in enumerate(arr):
        
        result += val * 0x100**i


    arr = arr[::-1]

    return result

def main():
    s = Solver()

    e = 359050389152821553416139581503505347057925208560451864426634100333116560422313639260283981496824920089789497818520105189684311823250795520058111763310428202654439351922361722731557743640799254622423104811120692862884666323623693713
    n = 26866112476805004406608209986673337296216833710860089901238432952384811714684404001885354052039112340209557226256650661186843726925958125334974412111471244462419577294051744141817411512295364953687829707132828973068538495834511391553765427956458757286710053986810998890293154443240352924460801124219510584689
    c = 67743374462448582107440168513687520434594529331821740737396116407928111043815084665002104196754020530469360539253323738935708414363005373458782041955450278954348306401542374309788938720659206881893349940765268153223129964864641817170395527170138553388816095842842667443210645457879043383345869

    #initialize flag, knowing that it matches the following format: "uiuctf{******************}"
    #where * is unknown

    flag = [ord(i) for i in "uiuctf{"]
    
    for i in range(18):
        char = BitVec('flag_'+str(i), 256)
        s.add(char >= ord('!'))
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
        print("something went very wrong, and the thing didn't even get solved. Sad")

if __name__ == "__main__":
    main()