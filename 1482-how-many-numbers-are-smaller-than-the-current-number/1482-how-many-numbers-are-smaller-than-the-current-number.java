class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int max = Arrays.stream(nums).max().getAsInt();       
        int[] freq = new int[max + 1];      
        Arrays.stream(nums).forEach(num -> freq[num]++);       
        for (int i = 1; i < freq.length; i++) freq[i] += freq[i - 1];  
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans[i] = 0; 
            } else {
                ans[i] = freq[nums[i] - 1]; 
            }
        }      
        return ans;
    }
}