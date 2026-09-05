class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        #rows
        for i in range (9):
            seen = set()
            for j in range (9):
                if board[i][j] != ".":
                    if board[i][j] in seen :
                        return False
                    seen.add(board[i][j])

        for i in range (9):
            seen = set()
            for j in range (9):
                if board[j][i] != ".":
                    if board[j][i] in seen :
                        return False
                    seen.add(board[j][i])

        for i in range(0,9,3):
            for j in range(0,9,3):
                seen = set()
                for row in range(i,i+3):
                    for col in range(j, j+3):
                        if board[row][col] != ".":
                            if board[row][col] in seen :
                                return False
                            seen.add(board[row][col])
        return True

