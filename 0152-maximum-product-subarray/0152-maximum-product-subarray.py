class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = max(nums)
        currMax, currMin = 1,1

        for num in nums:
            temp = currMax * num
            currMax = max(currMax * num, currMin * num, num)
            currMin = min(temp, currMin * num, num)
            res = max(currMax, res)
        return res
