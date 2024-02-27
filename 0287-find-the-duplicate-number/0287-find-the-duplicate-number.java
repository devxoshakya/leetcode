class Solution {
    public int findDuplicate(int[] nums) {
        Sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i+1 != nums[i]){
                return nums[i];
            }
        }
        return -1;
    }
    static void Sort(int[] a){
        int i=0;
        while(i<a.length){
            int correct = a[i]-1;
            if(a[i]!=a[correct]){
                int t = a[i];
                a[i] = a[correct];
                a[correct] = t;
            }else{
                i++;
            }
        }
    }
}