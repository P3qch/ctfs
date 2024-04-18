from sudoku import SudokuSolver, BIGGER, SMALLER, AdditionalRule
from pwn import *
from json import dumps

def get_grid(r: remote):
    grid = []
    
    row = []
    for _ in range(9):
        r.recvuntil(b'[')
        row = r.recvuntil(b']\n', drop = True).decode()
        row = [int(i) for i in row.split(', ')]
        grid.append(row)
    return grid

def get_additional_rule(r: remote):
    r.recvuntil(b'sum of the following numbers (at row,col) should be ')
    rule_type = SMALLER if r.recvuntil(b' ', drop = True) == b'smaller' else BIGGER
    r.recvuntil(b'than ')
    what = int(r.recvline(keepends=False).decode())
    cells = []
    line = r.recvline(keepends=False).decode()
    while 'solution' not in line:
        _, line = line[:-1].split(' : (')
        row, column = line.split(',')
        row, column = int(row), int(column)
        cells.append((row, column))
        line = r.recvline(keepends=False).decode()
        
    return AdditionalRule(cells, rule_type, what)

def main():
    r = remote('pwnable.kr', 9016)
    r.recvuntil(b"press enter to see example.")
    r.sendline()
    r.recvuntil(b'press enter to start game')
    r.sendline()

    for _ in range(100):
        grid = get_grid(r)

        info("Got grid")
    
        add_rule = get_additional_rule(r)
        pprint(grid)
        print(add_rule)
        solver = SudokuSolver(grid, add_rule)
        
        if not solver.solve():
            info("something went wrong :(")
            r.close()
            exit(1)
        
        info("solved it!! Here's your solution:")
        pprint(solver.grid)
        info("Sending solution to server...")
        r.sendline(dumps(solver.grid).encode())
        r.recvuntil(b'cheking your solution...')
        r.recvline()
        info("Server response: "+ r.recvline().decode())
    r.interactive()

if __name__ == "__main__":
    main()