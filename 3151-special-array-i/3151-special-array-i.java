class Solution {
    public boolean isArraySpecial(int[] nums) {
        int flag = nums[0] % 2;
        for(int i=1; i < nums.length; i++){
            if(flag == nums[i]%2){
                return false;
            }
            flag = nums[i]%2;
        }
        return true;
    }
}