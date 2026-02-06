class Solution {
    public int maxSubArray(int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE; 
        while(j < nums.length){
            sum += nums[j];
            max = Math.max(max,sum);
            if(sum < 0){
                sum = 0;
            }
            j++;
        }
        return max;
    }
}