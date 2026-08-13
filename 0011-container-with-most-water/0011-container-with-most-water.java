class Solution {
    public int maxArea(int[] h) {
        int l = 0;
        int r = h.length - 1;
        int minH = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (l < r) {
            minH = Math.min(h[r], h[l]);
            max = Math.max(max, minH * (r - l));
            if (h[r] < h[l]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

}