class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        cs = 0
        ct = 0
        while cs < len(s) and ct < len(t):
            if s[cs] == t[ct]:
                cs += 1
            ct += 1
        return cs == len(s)