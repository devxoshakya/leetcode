class Solution:
    def fourSum(self, nums: list[int], target: int) -> list[list[int]]:
        nums.sort()
        ans = set()
        n = len(nums)
        for i in range(n):
            for j in range(i+1, n):
                seen = set()
                for k in range(j+1, n):
                    req = target - nums[i] - nums[j] - nums[k]
                    if req in seen :
                        ans.add((nums[i],nums[j],nums[k],req))
                    seen.add(nums[k])
        return list(ans)