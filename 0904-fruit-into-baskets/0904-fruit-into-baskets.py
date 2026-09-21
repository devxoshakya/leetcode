class Solution:
    def totalFruit(self, fruits: list[int]) -> int:
        l, res = 0,0
        count = {}

        for r in range(len(fruits)):
            count[fruits[r]] = 1 + count.get(fruits[r], 0) 

            while len(count) > 2 :
                f = fruits[l]
                count[f] -= 1
                l += 1
                if not count[f]:
                    count.pop(f)
            res = max(res, r - l + 1)
        return res