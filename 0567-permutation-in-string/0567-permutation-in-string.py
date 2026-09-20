class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n1, n2 = len(s1), len(s2)

        if n1 > n2:
            return False

        f1 = [0] * 26
        f2 = [0] * 26

        # Initial window
        for i in range(n1):
            f1[ord(s1[i]) - 97] += 1
            f2[ord(s2[i]) - 97] += 1

        if f1 == f2:
            return True

        # Sliding window
        for i in range(n1, n2):
            f2[ord(s2[i]) - 97] += 1
            f2[ord(s2[i - n1]) - 97] -= 1

            if f1 == f2:
                return True

        return False