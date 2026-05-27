class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int tempMax = max;
            int tempMin = min;

            max = Math.max(n, Math.max(n * tempMax, n * tempMin));
            min = Math.min(n, Math.min(n * tempMax, n * tempMin));

            res = Math.max(res, max);

        }
        return res;
    }
}