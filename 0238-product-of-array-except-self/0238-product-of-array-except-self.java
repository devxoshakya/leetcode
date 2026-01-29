class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        //prefix multiplication
        for(int i=1; i<ans.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int suffix = 1;
        for(int i = ans.length-1; i >=0; i--){
            ans[i] *= suffix;
            suffix *= nums[i];
        }

        return ans;
    }
}