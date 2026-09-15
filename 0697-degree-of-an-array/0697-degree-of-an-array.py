class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        count = {}
        first = {}
        last = {}
        
        # Track frequencies, first occurrences, and last occurrences
        for i, num in enumerate(nums):
            if num not in first:
                first[num] = i
            last[num] = i
            count[num] = count.get(num, 0) + 1
            
        # 1. Find the maximum frequency (degree) of the array
        degree = max(count.values())
        
        # 2. Find the minimum subarray length among all elements that match the degree
        min_length = len(nums)
        for num in count:
            if count[num] == degree:
                length = last[num] - first[num] + 1
                min_length = min(min_length, length)
                
        return min_length
