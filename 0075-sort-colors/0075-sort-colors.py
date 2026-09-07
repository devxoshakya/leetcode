class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        r  = 0
        l = len(nums) - 1
        mid = 0
        while(mid <= l):
            if nums[mid] == 0:
                temp = nums[mid]
                nums[mid] = nums[r]
                nums[r] = temp
                r+=1
                mid +=1
            elif nums[mid] == 1:
                mid += 1
            elif nums[mid] == 2:
                temp = nums[mid]
                nums[mid] = nums[l]
                nums[l] = temp
                l -= 1
        