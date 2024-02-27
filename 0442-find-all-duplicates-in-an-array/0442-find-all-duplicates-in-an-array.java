class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Sort(nums);
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i<nums.length; i++){
            if(i+1 != nums[i]){
                res.add(nums[i]);
            }
        }
        return res;
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