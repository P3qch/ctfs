from hashlib import md5

def encrypt(string):
    text = string
    for _ in range(20):
        text = md5(text).hexdigest().upper().encode()
    
    return text


for i in range(ord(' '), ord('~') + 1):
    for j in range(ord(' '), ord('~') + 1):
        for k in range(ord(' '), ord('~') + 1):    
            for l in range(ord(' '), ord('~') + 1):
                string = chr(i) + chr(j) + chr(k) + chr(l)
                string = string.encode()
                encrypted = encrypt(string)
                #print(f"{string}: {encrypted}")
                if encrypted == b"2D3114BCC2E5C58BBAC77F04237723D9":
                    print(string)

    print(100 * ((i - ord(' ')) / (ord('~') - ord(' '))))


# pin is: 5cRt