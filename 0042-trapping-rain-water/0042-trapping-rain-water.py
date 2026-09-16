class Solution:
    def trap(self, height: list[int]) -> int:
        l_wall = r_wall = 0
        n = len(height)
        L = [0] * n
        R = [0] * n

        for i in range(n):
            j = -i -1
            L[i] = l_wall
            R[j] = r_wall
            l_wall = max(l_wall, height[i])
            r_wall = max(r_wall, height[j])
        
        sum = 0
        for i in range(n):
            pot = min(L[i],R[i])
            sum += max(0, pot - height[i])
        
        return sum