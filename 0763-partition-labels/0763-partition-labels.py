class Solution:
    def partitionLabels(self, s: str) -> list[int]:
        idx = {}
        size = 0
        end = 0
        res = []
        for i, n in enumerate(s):
            idx[n] = i

        for i, ch in enumerate(s):
            size += 1
            end = max(end, idx[ch])
            if i == end:
                res.append(size)
                size = 0
        return res
