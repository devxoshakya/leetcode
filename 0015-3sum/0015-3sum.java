class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0; i < nums.length; i++){
            Set<Integer> seen = new HashSet<>();
            for(int j=i+1; j < nums.length; j++){
                int third = - (nums[i] + nums[j]);
                if(seen.contains(third)){
                    set.add(Arrays.asList(nums[i],third,nums[j]));
                }
                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(set);
    }
}