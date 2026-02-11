class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int b = 0;
        int count = 0;
        for(int i : nums){
            if(i > 0){
                b += i;
            } else {
                b += i;
            }

            if(b == 0){
                count++;
            }
        }

        return count;
    }
}