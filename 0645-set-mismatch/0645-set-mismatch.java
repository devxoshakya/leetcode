class Solution {
    public int[] findErrorNums(int[] nums) {
        Sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i+1 != nums[i]){
                return new int[] {nums[i], i+1};
            }
        }
        return null;
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
// {a[i],i+1}