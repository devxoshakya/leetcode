class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int[] arr = new int[nums.length];

        for(int i : arr){
            i = 0;
        }

        for(int j=0; j<arr.length; j++){
            arr[nums[j]-1] = 1;
        }

        List<Integer> l = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 0){
                l.add(i+1);
            }
        }
        return l;
    }
}