class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : map.keySet()) {
            freq[map.get(n)].add(n);
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = freq.length - 1; i >= 0; i--) {
            for (int n : freq[i]) {
                res[index++] = n;

                if (index == k)
                    return res;
            }
        }

        return res;
    }
}