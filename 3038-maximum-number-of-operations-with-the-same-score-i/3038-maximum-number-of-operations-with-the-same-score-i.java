class Solution {
    public int maxOperations(int[] nums) {
        if(nums.length < 2) return 0;
        int l = 0;
        int r = 1;
        int op = nums[l] + nums[r];
        int count = 1;
        l +=2; r +=2;
        while(l < nums.length && r < nums.length){
            
            if(nums[l]+nums[r] == op){
                count++;
                l+=2; r+=2;
            } else {
                break;
            }
        }
        return count;
    }
}