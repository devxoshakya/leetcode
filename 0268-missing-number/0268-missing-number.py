class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        sum = n * (n + 1) / 2
        _sum = 0
        for num in nums:
            _sum += num
        return int(sum - _sum)