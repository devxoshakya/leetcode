class Solution:
    def fourSumCount(self, A: list[int], B: list[int], C: list[int], D: list[int]) -> int:
        ans = 0
        count = {}
        for a in A:
            for b in B:
                s = a + b
                count[s] = 1 + count.get(s,0)

        for c in C :
            for d in D:
                target = -(c+d)
                if target in count :
                    ans += count[target]
        return ans
