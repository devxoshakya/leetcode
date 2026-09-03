class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        count = {}
        n = len(nums)

        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in count:
                return [count[complement],i]
            count[nums[i]] = i
        return []
        

        