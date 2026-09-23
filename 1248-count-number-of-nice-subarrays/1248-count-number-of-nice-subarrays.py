class Solution:
    def numberOfSubarrays(self, nums: list[int], k: int) -> int:
        def mostK(k : int) -> int:
            l = res = odd = 0

            for i in range(len(nums)):
                odd += nums[i] % 2

                while odd > k:
                    odd -= nums[l] % 2
                    l += 1
                res += i - l + 1
            return res
        return mostK(k) - mostK(k-1)
