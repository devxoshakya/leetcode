class Solution:
    def maxSatisfied(self, customers: list[int], grumpy: list[int], minutes: int) -> int:
        l = 0
        window, max_win = 0,0
        satisfied = 0
        for r in range(len(grumpy)):
            if grumpy[r]:
                window += customers[r]
            else :
                satisfied += customers[r]

            if r - l + 1 > minutes:
                if grumpy[l]:
                    window -= customers[l]
                l += 1
            
            max_win = max(window, max_win)
        return satisfied + max_win