class Solution:
    def reverseVowels(self, st: str) -> str:
        s = list(st)
        l, r = 0, len(s) - 1
        # Using a set provides O(1) lookups and handles uppercase automatically
        vowels = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"}
        
        while l < r:
            # Added "l < r" check to prevent IndexError
            while l < r and s[l] not in vowels:
                l += 1
            # Added "l < r" check to prevent IndexError
            while l < r and s[r] not in vowels:
                r -= 1
                
            # Swap the vowels
            s[l], s[r] = s[r], s[l]
            
            # Move pointers inward
            l += 1
            r -= 1
            
        return "".join(s)