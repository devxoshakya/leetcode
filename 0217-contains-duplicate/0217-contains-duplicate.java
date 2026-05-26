class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
            if(freq.get(i) >= 2){
                return true;
            }
        }
        return false;
    }
}