class Solution {
    public int maxSubArray(int[] nums) {
        int windowSum = 0;
        int maxWindow = Integer.MIN_VALUE;
        for(int i : nums){
            windowSum += i;
            maxWindow = Math.max(windowSum,maxWindow);
            if(windowSum <= 0){
                windowSum = 0;
            }

        }
        return maxWindow;
    }
}