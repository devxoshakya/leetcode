class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i < nums.length; i++){
            if(nums[i] < 0){
                nums[i] = 0;
            }
        }

        for(int i=0; i < nums.length; i++){
            int abs = Math.abs(nums[i]);
            if(abs >= 1 && abs <= nums.length){
                if(nums[abs-1] > 0){
                    nums[abs-1] *= -1;
                } else if(nums[abs-1] == 0){
                    nums[abs-1] = -1 * (nums.length + 1);
                }
            }
        }

        for(int i=1; i <= nums.length; i++){
            if(nums[i-1] >= 0){
                return i;
            }
        }
        return nums.length+1;
    }
}