class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        _set = set()
        nums.sort()

        for i in range(len(nums)):
            seen = set()
            for j in range(i+1, len(nums)):
                comp = -(nums[i] + nums[j])
                if comp in seen :
                    _set.add((nums[i], comp, nums[j]))
                seen.add(nums[j])
        return list(_set)