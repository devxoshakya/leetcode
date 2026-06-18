class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> q = new ArrayDeque<>();
        int idx = 0;

        for (int r = 0; r < n; r++) {

            // Remove smaller elements from back
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[r]) {
                q.pollLast();
            }

            q.offerLast(r);

            // Remove elements outside window
            if (q.peekFirst() <= r - k) {
                q.pollFirst();
            }

            // Window formed
            if (r >= k - 1) {
                res[idx++] = nums[q.peekFirst()];
            }
        }

        return res;
    }
}