# dos4fun
## Initial analysis

Using `strings`, I figured that this is a Borland Turbo C DOS binary. Therefore, to debug, I'll use the Borland Turbo Debugger and for static analysis the Ghidra decompiler. Ghidra doesn't understand the symbols from this binary, so I copied them from the Turbo Debugger manually. Additionally, Ghidra had trouble understanding that the addresses point to the data segment, so I added a segment mapping to `DS` at `0000:0000`. After this adjustment, Ghidra was able to interpret the binary correctly.

---

## Static analysis

### The `main` function
```c
undefined2 __cdecl16near main(void)
{
  int iVar1;
  undefined2 uVar2;
  char *__format;
  char input [64];
  
  printf((char *)s_User_id_:_130a_01a8);
  scanf((char *)s_%64s_130a_01b3,input);
  fflush((FILE *)0x328);
  iVar1 = strcmp(input,(char *)s_capturetheflag_130a_01b8);
  if (iVar1 == 0) {
    _enter_keys();
    _encrypt();
    iVar1 = _verify_keys();
    if (iVar1 == 0) {
      __format = (char *)s_wrong_serial_130a_020f;
    }
    else {
      __format = (char *)s_Wow.._how_did_you_managed_to_get_130a_01c7;
    }
    printf(__format);
    getch();
    uVar2 = 1;
  }
  else {
    uVar2 = 0;
  }
  return uVar2;
}
```

The **main** function takes user input for the "user id:" prompt and compares it to `"capturetheflag"`. If the input matches, it calls the following functions:

1. **_enter_keys**
2. **_encrypt**
3. **_verify_keys**

---
### The `_enter_keys` function
```c

undefined2 __cdecl16near _enter_keys(void)

{
  FILE *pFVar1;
  
  pFVar1 = fopen((char *)s_keys_130a_00cc,(char *)s_w_130a_00d1);
  if (pFVar1 == (FILE *)0x0) {
    printf((char *)s_cant_create_file_130a_00d3);
    exit(0);
  }
  printf((char *)s_Enter_25_serial_numbers_:_130a_00e6);
  scanf((char *)s_%d_%d_%d_%d_%d_%d_%d_%d_%d_%d_%d_130a_0101,0x656,0x658,0x65a,0x65c,0x65e,0x660,
        0x662,0x664,0x666,0x668,0x66a,0x66c,0x66e,0x670,0x672,0x674,0x676,0x678,0x67a,0x67c,0x67e,
        0x680,0x682,0x684,0x686);   // <--- this numbers point to the keys array. didnt manage to make ghidra understand that...
  fwrite(0x656,2,0x19,pFVar1);
  fclose(pFVar1);
  printf((char *)s_keys_saved_into_file_130a_014c);
  return 0;
}

```
The **_enter_keys** function:
- Opens the file `keys` in write mode (`w`).
- Prompts the user for 25 serial numbers.
- Writes these numbers (as `int16`) into the file.

---

### The `_encrypt` function
```c

void __cdecl16near _encrypt(void)

{
  FILE *stream;
  int byte_num;
  char *iVar2;
  int i;
  
  stream = fopen((char *)s_keys_130a_017a,(char *)s_rb+_130a_017f);
  if (stream == (FILE *)0x0) {
    printf((char *)s_cant_open_file_130a_0183);
    exit(0);
  }
  byte_num = _fsize(stream);
  iVar2 = (char *)malloc(byte_num);
  fread(iVar2,1,byte_num,stream);
  for (i = 0; i < byte_num; i = i + 1) {
    iVar2[i] = iVar2[i] ^ 0xff;
  }
  fseek(stream,0,0,0);
  fwrite(iVar2,1,byte_num,stream);
  fclose(stream);
  free(iVar2);
  printf((char *)s_keys_are_encrypted_130a_0194);
  return;
}

```
The **_encrypt** function:
- Opens the file `keys` in read-write binary mode (`rb+`).
- Reads the file content into an allocated buffer.
- XORs each byte with `0xFF` to encrypt the file content.
- Writes the encrypted content back into the file.

_Note: The `fsize` function is not a built-in, and it uses `fseek` and `ftell` to calculate the number of bytes in the file (physically)._

---

### The `_verify_keys` function
```c
undefined2 __cdecl16near _verify_keys(void)

{
  FILE *pFVar1;
  undefined2 uVar2;
  uint key_s [25];
  
  pFVar1 = fopen((char *)s_keys_130a_0162,(char *)s_r_130a_0167);
  if (pFVar1 == (FILE *)0x0) {
    printf((char *)s_cant_open_file_130a_0169);
    exit(0);
  }
  uVar2 = _fsize(pFVar1,pFVar1);
  fread(key_s,1,uVar2);
  fclose(pFVar1);
  if ((((((((key_s[0] < key_s[1]) && (key_s[1] < key_s[2])) && (key_s[2] < key_s[3])) &&
         (((key_s[3] < key_s[4] && (key_s[4] < key_s[5])) &&
          ((key_s[5] < key_s[6] && ((key_s[6] < key_s[7] && (key_s[7] < key_s[8])))))))) &&
        (key_s[8] < key_s[9])) &&
       (((((key_s[9] < key_s[10] && (key_s[10] < key_s[11])) && (key_s[11] < key_s[12])) &&
         ((key_s[12] < key_s[13] && (key_s[13] < key_s[14])))) &&
        ((key_s[14] < key_s[15] && ((key_s[15] < key_s[16] && (key_s[16] < key_s[17])))))))) &&
      ((key_s[17] < key_s[18] &&
       (((key_s[18] < key_s[19] && (key_s[19] < key_s[20])) && (key_s[20] < key_s[21])))))) &&
     (((key_s[21] < key_s[22] && (key_s[22] < key_s[23])) &&
      ((key_s[23] < key_s[24] && (key_s[24] < key_s[0])))))) {
    uVar2 = 1;
  }
  else {
    uVar2 = 0;
  }
  return uVar2;
}

```

The **_verify_keys** function:
- Opens the file `keys` in read mode (`r`) 
- Reads the file into a 50 byte long buffer
- Performs some comparisons that are impossible to satisfy (because to satisfy them, `key_s[0]` must be bigger than itself)

---

## The bug

The file `keys` is opened with textual modes in the functions `_enter_keys` and `_verify_keys`, while being a binary file.

When i noticed the difference between the modifiers I went to research. Appearently when you use the textual modifiers (e.g. 'r','w' without the 'b' flag) the program will translate any special characters based on the operating system. 

In our case - in MS-DOS:
- '\n' will be written as '\r\n' 
- '\r\n' will be read as '\n'

This is done to simplify working with textual files, while in this case the file is not textual, and therefore this behaviour is exploitable.

In _verify_keys the file is read into a 50 byte buffer. If we leverage the bug in the code, we can make the file longer than 50 bytes - by putting the byte 0xa ('\n') in the keys, as they will be written as 0x0d0a ('\r\n') to the file - thus multiplying themselves by two, and giving us a buffer-overflow.

To test this I used the following payload:
```py
In [11]: (str(0x0a0a)+" ")*2 + "1 " * 22 + str(0x5d5 ^ 0xffff)
Out[11]: '2570 2570 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 64042'
```
(0x5d5 is the address to print "Wow.. how did you managed to get here? anyway pwnme and read the flag!")

When we try it:
```
C:\>DOS4FUN.EXE
User id : capturetheflag
Enter 25 serial numbers : 2570 2570 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 64042
keys saved into file
fp is valid : 378
keys are encrypted
fp is valid : 378
Wow.. how did you managed to get here? anyway pwnme and read the flag!
```

We got a POC! Great now we have to get this to do something useful.