class Solution {
    public int findNumbers(int[] nums) {
        int even = 0;
        for(int i=0; i<nums.length; i++){
            if((digits(nums[i]))%2==0){
                even++;
            }
        }
        return even;
    }
    static int digits(int n){
        
        return (int)Math.log10(n)+1;
    }
}