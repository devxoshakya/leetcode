class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;

        int[] dummy = new int[k];

        for (int i = 0; i < k; i++) {
            dummy[i] = nums[n - k + i];
        }

        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = dummy[i];
        }
    }
}