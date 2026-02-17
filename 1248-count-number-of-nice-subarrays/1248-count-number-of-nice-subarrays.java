class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        // convert even→0, odd→1
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] % 2;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); // important

        int prefixSum = 0;
        int count = 0;

        for(int num : nums){

            prefixSum += num;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
