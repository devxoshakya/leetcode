class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int limit = nums.length/3 + 1;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }

        for(int i : freq.keySet()){
            if(freq.get(i) >= limit ){
                res.add(i);
            }   
        }
        return res;
    }
}