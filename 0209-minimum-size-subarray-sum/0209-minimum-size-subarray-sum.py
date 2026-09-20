class Solution:
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        l, total = 0,0
        res = inf
        for r in range(len(nums)):
            total += nums[r]
            while total >= target:
                res = min(res, r - l + 1)
                total -= nums[l]
                l += 1
            
            

        return 0 if res == inf else res 