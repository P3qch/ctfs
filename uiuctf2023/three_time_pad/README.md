# Three Time Pad - uiuctf 2023
## writeup by p3qch :D
Challange description:
```
"We've been monitoring our adversaries' communication channels, but they encrypt their data with XOR one-time pads! However, we hear rumors that they're reusing the pads...\n\nEnclosed are three encrypted messages. Our mole overheard the plaintext of message 2. Given this information, can you break the enemy's encryption and get the plaintext of the other messages?"
```
So we're given three encrypted thingies, and we know they're encrypted using a XOR pad, and they're all encrypted by the same one. You might already know that the opposite of xor is xor, therefore if `x^y=z`, `z^y=x` and `y^z=x` is true.
Using that we could find the pad, and solve the other ciphers.
Here's some crap code i wrote to quickly solve this challange:

```py
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
```
We run it and we get the following:

```
$ python3 ./solve.py       
before computers, one-time pads were sometimesprinted on flammable material so that spies could uiuctf{burn_3ach_k3y_aft3r_us1ng_1t}                       
```

And we got that sweet flag! Hooray!