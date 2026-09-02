class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = {}
        ans = []
        for i in nums1:
            m[i] = m.get(i,0) + 1

        for j in nums2:
            if(m.get(j,0) > 0):
                ans.append(j)
                m[j] = m.get(j,0) - 1
        return ans