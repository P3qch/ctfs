from pprint import pprint
from os import system
SMALLER = 0
BIGGER = 1

class AdditionalRule:
    def __init__(self, cells, rule_type, what):
        """
        Cells: tuples of (row, column) for the sum
        rule_type: sum should be bigger or smaller
        what: sum should be bigger/smaller than *what*
        """
        self.cells = cells
        self.rule_type = rule_type
        self.what = what

    def __repr__(self):
        return (f"AdditionalRule({self.cells}, {self.rule_type}, {self.what})")

    def check(self,grid):
        sum_of_cells = 0
        zeroes = False
        for cell in self.cells:
            if grid[cell[0] - 1][cell[1] - 1] == 0:
                zeroes = True
                return True
            sum_of_cells += grid[cell[0] - 1][cell[1] - 1]



        if self.rule_type == SMALLER:

            return sum_of_cells < self.what
        elif self.rule_type == BIGGER:

            return sum_of_cells > self.what

class SudokuSolver:
    def __init__(self, grid, add_rule):
        """
        grid - 9x9 2d list
        """
        self.grid = grid
        self.add_rule = add_rule


    def has_dupes(l) -> bool:
        """
        returns true if l has duplicates that are not 0
        """
        l = list(filter((0).__ne__, l))
        return len(set(l)) != len(l)


    def is_legal(self):
        if not self.add_rule.check(self.grid):
            return False

        for row in self.grid:
            if SudokuSolver.has_dupes(row):
                return False

        for col_i in range(9):
            col = [self.grid[row_i][col_i] for row_i in range(9)]
            if SudokuSolver.has_dupes(col):
                return False

        for square_y in range(0, 9, 3):
            for square_x in range(0, 9, 3):
                square = sum([[self.grid[square_y + i][square_x + j] for j in range(3)] for i in range(3)], [])
                if SudokuSolver.has_dupes(square):
                    return False
        return True

    def is_solved(self):
        return self.is_legal() 


    def solve(self, start_row = 0, start_col = 0):
        if start_row == 8 and start_col == 8:
            return self.is_solved()
        while start_row < 9 and start_col < 9  and self.grid[start_row][start_col] != 0:
            if start_col == 8:
                start_row += 1
                start_col = 0
            else:
                start_col += 1

        if start_row >= 9 or start_col >= 9:
            
            return self.is_solved()

        for i in range(1, 10):
            self.grid[start_row][start_col] = i
            if not self.is_legal():
                self.grid[start_row][start_col] = 0
                continue


            if self.solve(start_row = start_row , start_col = start_col):
                return True
            else:
                self.grid[start_row][start_col] = 0
                continue


        return False
            

if __name__ == "__main__":
    grid = [[0, 0, 0, 6, 0, 8, 0, 0, 0],
            [0, 9, 0, 3, 5, 2, 0, 0, 0],
            [8, 0, 0, 4, 9, 7, 3, 2, 5],
            [9, 4, 1, 0, 0, 6, 5, 3, 0],
            [5, 0, 0, 9, 8, 0, 2, 0, 4],
            [7, 8, 2, 5, 0, 3, 0, 6, 9],
            [3, 5, 0, 8, 6, 4, 0, 1, 0],
            [0, 0, 8, 7, 3, 5, 4, 9, 0],
            [6, 7, 4, 1, 0, 9, 8, 0, 3]]
    add_rule = AdditionalRule([(1, 9), (4, 5), (6, 7), (8, 2)], 0, 20)
    solver = SudokuSolver(grid, add_rule)
    print(solver.solve())

    pprint(solver.grid)