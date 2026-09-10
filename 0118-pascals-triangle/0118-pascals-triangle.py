class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]
        for i in range(numRows - 1):
            row = []
            temp = [0] + res[-1] + [0]
            for j in range(len(res[-1])+1):
                row.append(temp[j] + temp[j+1])
            res.append(row)
        return res
