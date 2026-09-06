class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        limit = len(nums) // 3
        freq = {}

        for num in nums:
            freq[num] = 1 + freq.get(num, 0)

            if len(freq) <= 2:
                continue

            temp = {}
            for key in freq:
                if freq[key] > 1:
                    temp[key] = freq[key] - 1
            freq = temp

        result = []

        for key in freq:
            count = 0
            for num in nums:
                if num == key:
                    count += 1

            if count > limit:
                result.append(key)

        return result
