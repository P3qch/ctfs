with open('c2', 'rb') as f:
    c2 = f.read(1024)

with open('p2', 'rb') as f:
    p2 = f.read(1024)

assert len(p2) == len(c2)

pad = [0 for _ in range(len(c2))]

for i in range(len(p2)):
    pad[i] = c2[i] ^ p2[i]

with open("c1", 'rb') as f:
    c1 = f.read(1024)
    for i in range(len(c1)):
        print(chr(c1[i] ^ pad[i]),end='')

print(p2.decode(), end=' ')
with open("c3", 'rb') as f:
    c3 = f.read(1024)
    for i in range(len(c3)):
        print(chr(c3[i] ^ pad[i]),end='')