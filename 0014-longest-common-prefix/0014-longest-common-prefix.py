class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix = strs[0]

        for i in range(len(prefix)):
            for s in strs[1:]:
                if(i >= len(s) or s[i] != prefix[i]):
                    return prefix[:i]
        return prefix