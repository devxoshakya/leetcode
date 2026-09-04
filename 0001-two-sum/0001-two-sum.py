class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        _map = {}
        n = len(nums)
        for i in range(n):
            comp = target - nums[i]
            if comp in _map :
                return [_map[comp],i]
            _map[nums[i]] = i
        return []
        

        