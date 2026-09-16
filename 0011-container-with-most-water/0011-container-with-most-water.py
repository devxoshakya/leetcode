class Solution:
    def maxArea(self, h: list[int]) -> int:
        left = 0
        right = len(h)-1
        area = 0
        while left < right:
            min_h = min(h[left], h[right])
            area = max(area, min_h * (right - left))
            if h[left] < h[right]:
                left += 1
            else :
                right -= 1
        return area