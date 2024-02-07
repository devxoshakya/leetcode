class Solution {
    public int findNumbers(int[] nums) {
        int even = 0;
        for(int i=0; i<nums.length; i++){
            if(digits(nums[i])%2==0){
                even++;
            }
        }
        return even;
    }
    static int digits(int n){
        int res = 0;
        while(n!=0){
            n = n/10;
            res++;
        }
        return res;
    }
}