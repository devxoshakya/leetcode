class Solution:
    def longestSubarray(self, nums: list[int]) -> int:
        l, r = 0, 0
        ans = 0
        zeroes = 0

        while r < len(nums):
            if nums[r] == 0:
                zeroes += 1
            while zeroes > 1:
                if nums[l] == 0:
                    zeroes -= 1
                l += 1

            ans = max(ans, r - l)
            r += 1
        return ans
