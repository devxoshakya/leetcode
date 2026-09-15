class Solution:
    def isPalindrome(self, s: str) -> bool:
        _s = ""
        for i in range(len(s)):
            if s[i].isalpha() or s[i].isdigit():
                _s += s[i].lower()
        return _s == _s[::-1]