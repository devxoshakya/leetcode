class Solution:
    def maxScore(self, cardPoints: list[int], k: int) -> int:
        n = len(cardPoints)
        total = sum(cardPoints)

        if n == k:
            return total

        window = n - k
        curr = sum(cardPoints[:window])
        min_sum = curr

        for r in range(window, n):
            curr += cardPoints[r] - cardPoints[r - window]
            min_sum = min(min_sum, curr)

        return total - min_sum