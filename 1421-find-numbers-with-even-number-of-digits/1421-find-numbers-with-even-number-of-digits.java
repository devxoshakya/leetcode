class Solution {
    public int findNumbers(int[] nums) {
        int res=0;
        for(int num: nums){
            if(cout(num)%2==0){
                res++;
            }
        }
        return res;
    }
    private int cout(int num){
        return (int)Math.log10(num)+1;
    }
}