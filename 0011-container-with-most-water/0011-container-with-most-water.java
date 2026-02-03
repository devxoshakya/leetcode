class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while(l <  r){
            int width = r - l;
            int minHeight = Math.min(height[l],height[r]);
            maxArea = Math.max(maxArea, width * minHeight);

            if(height[l] < height[r]) l++;
            else r--;
        }

        return maxArea;
    }
}