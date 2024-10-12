class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int first = 0;
        int mid = n;
        for(int i=0; i<res.length; i++){
           res[i] = nums[first];
           i++;
           res[i] = nums[mid];
           mid++;
           first++;
        }
        return res;
    }
}