class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        res = [0] * len(nums)
        end = len(res)-1
        left = 0
        right = len(nums)-1
        while left <= right:
            if abs(nums[left]) < abs(nums[right]):
                res[end] = nums[right] * nums[right]
                end -= 1
                right -= 1
            else :
                res[end] = nums[left] * nums[left]
                end -= 1
                left += 1
        return res