class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int freq = e.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(e.getKey());
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    ans[index++] = num;
                    if (index == k)
                        break;
                }
            }
        }

        return ans;
    }
}