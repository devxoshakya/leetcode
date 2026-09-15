class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        l = [1] * len(nums)
        for i in range(len(nums)-1,-1,-1):
            for j in range(i+1, len(nums)):
                if nums[i] < nums[j] :
                    l[i] = max(l[i], l[j] + 1)
        return max(l)