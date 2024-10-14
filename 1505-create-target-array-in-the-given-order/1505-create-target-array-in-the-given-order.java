class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
ArrayList<Integer> list=new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(index[i], nums[i]);
        }
        int target[]=new int[list.size()];
        for(int i=0; i<list.size(); i++){
            target[i]=list.get(i);
        }
        return target;    }

    private void insertAtIndex(int[] arr, int idx, int val){
        for(int i=arr.length-2; i>=0; i--){
            if(i!=idx){
                arr[1+i] = arr[i];
            }else{
                arr[i] = val;
            }
        }
    }
}