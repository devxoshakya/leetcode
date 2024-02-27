class Solution {
    public int firstMissingPositive(int[] nums) {
        Sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i+1 != nums[i]){
                return i+1;
            }
        }
        return nums.length + 1;
    }
    static void Sort(int[] a){
        int i=0;
        while(i<a.length){
            int correct = a[i]-1;
            if(a[i]>0 && a[i]<=a.length && a[i]!=a[correct]){
                int t = a[i];
                a[i] = a[correct];
                a[correct] = t;
            }else{
                i++;
            }
        }
    }
}