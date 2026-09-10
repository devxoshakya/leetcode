class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = {}
        ans = []
        for num in nums1:
            m[num] = 1 + m.get(num,0)

        for num in nums2:
            if m.get(num,0) > 0:
                ans.append(num)
                m[num] = m.get(num,0) - 1
        return ans