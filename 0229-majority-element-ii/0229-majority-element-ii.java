class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int limit = nums.length / 3;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);

            if(freq.size() <= 2) continue;

            HashMap<Integer, Integer> dummy = new HashMap<>();
            for(int key : freq.keySet()){
                if(freq.get(key) > 1){
                    dummy.put(key,freq.get(key)-1);
                }
            }
            freq = dummy;
        }

        for(int key : freq.keySet()){
            if(count(nums,key) > limit){
                res.add(key);
            }
        }

        return res;
    }

    private int count(int[] nums, int k) {
        int count = 0;
        for (int num : nums) {
            if (num == k) {
                count++;
            }
        }
        return count;
    }
}