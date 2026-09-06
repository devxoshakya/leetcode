class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        freq = {}
        freq[0] = 1
        sum = 0
        count = 0

        for num in nums:
            sum += num
            need = sum - k
            if need in freq:
                count += freq[need]
            freq[sum] = freq.get(sum,0) + 1
        return count