class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = -inf
        sum = 0
        for num in nums:
            if sum <= 0:
                sum = 0
            sum += num
            res = max(res,sum)
        return res
