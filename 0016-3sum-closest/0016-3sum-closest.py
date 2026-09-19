class Solution:
    def threeSumClosest(self, nums: list[int], target: int) -> int:
        nums.sort()
        closest_sum = inf
        n = len(nums)

        for i in range(n):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            l, r = i + 1, n-1
            while l < r :
                curr_sum = nums[i] + nums[l] + nums[r]

                if abs(curr_sum - target) < abs(closest_sum - target):
                    closest_sum = curr_sum

                if curr_sum == target:
                    return curr_sum 
                elif curr_sum < target :
                    l += 1
                else :
                    r -= 1
        return closest_sum  