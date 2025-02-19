class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = nums[0];
        for(int i=0; i<nums.length; i++){
            int current = nums[i];
            if(Math.abs(current)<Math.abs(closest)){
                closest = current;
            }
            else if(Math.abs(current) == Math.abs(closest) && current > closest){
                closest = current;
            }
        }
        return closest;
    }
}