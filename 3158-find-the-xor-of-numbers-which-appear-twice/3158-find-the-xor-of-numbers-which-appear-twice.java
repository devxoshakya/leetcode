class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int xor = 0;
        for(int i : nums){
            if(map.containsKey(i)){
                xor ^= i;
            } else {
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }

        return xor;
    }
}