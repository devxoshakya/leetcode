class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        l = m - 1
        r = m + n - 1
        p = n - 1
        while(p >= 0):
            if l >= 0 and nums1[l] > nums2[p]:
                nums1[r] = nums1[l]
                l -= 1
            else :
                nums1[r] = nums2[p]
                p -= 1
            r -= 1
        