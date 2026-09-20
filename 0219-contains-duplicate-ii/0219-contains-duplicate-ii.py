class Solution:
    def containsNearbyDuplicate(self, nums: list[int], k: int) -> bool:
        count = {}
        for i, num in enumerate(nums):
            if num in count :
                if abs(count[num] - i) <= k:
                    return True
            count[num] = i
        return False