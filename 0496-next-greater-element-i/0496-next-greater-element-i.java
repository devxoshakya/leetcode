class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i],i);
        }

        Arrays.fill(nums1,-1);
        Stack<Integer> s = new Stack<>();

        for(int curr : nums2){
            while(!s.isEmpty() && curr > s.peek()){
                int val = s.pop();
                int idx = map.get(val);
                nums1[idx] = curr;
            }
            if(map.containsKey(curr)){
                s.push(curr);
            }
        }

        return nums1;
    }
}