class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i : nums) {
            set.add(i);
        }

        for (int i : set) {
            if (!set.contains(i - 1)) {
                
                int len = 1;
                while (set.contains(i + len)) {
                    len++;
                }
                count = Math.max(len, count);
            }
        }
        return count;
    }
}