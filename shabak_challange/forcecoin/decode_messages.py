from hashlib import md5

def doMd5(string):
    return md5(string.encode()).hexdigest()


def decode_hash_list(hash_list):
    result = ""
    for h in hash_list:
        for c in range(ord(' '), ord('~') + 1):
            result += chr(c)
            if doMd5(result) == h:
                break
            result = result[:-1]
    return result

def  main():
    with open('db.txt', 'r') as f:
        text = f.read()

    lines = text.split('\n')
    for line in lines:
        if '[' in line and ']' in line:
            print(line[:line.index('[')] + ': ', end = '')
            hash_list = line[line.index('[') + 1 : line.index(']')].split(', ')
            print(decode_hash_list(hash_list))


if __name__ == "__main__":
    main()