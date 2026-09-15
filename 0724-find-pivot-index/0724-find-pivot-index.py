class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        R = [0] * len(nums)
        L = [0] * len(nums)
        L[0] = nums[0]
        R[len(nums)-1] = nums[len(nums)-1]

        for i in range(1,len(nums)):
            L[i] = L[i-1] + nums[i]

        for i in range(len(nums)-2, -1, -1):
            R[i] = R[i+1] + nums[i]
        
        for i in range(len(nums)):
            if L[i] == R[i]:
                return i
        return -1