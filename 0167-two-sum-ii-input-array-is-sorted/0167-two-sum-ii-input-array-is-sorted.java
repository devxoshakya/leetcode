class Solution {
    public int[] twoSum(int[] n, int target) {
        int s =0;
        int e =  n.length-1;
        while(e>=s){
            if((n[s]+n[e]) == target){
                return new int[] {s+1, e+1};
            }
            if(n[s]+n[e]>target){
                e--;
            }
            else{
                s++;
            }
        }
        return new int[] {-1,-1};
    }
}