class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (i < 2) {
                nums[i++] = nums[j];
            } else if (nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}