class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int nonCircular = kaden(nums);
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i];
        }

        int circular = totalSum + kaden(nums);
        if (circular == 0)
            return nonCircular;

        return Math.max(nonCircular, circular);
    }

    private int kaden(int[] nums) {
        int curr = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
        }
        return max;
    }
}