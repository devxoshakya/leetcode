class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0;
        int current = 1;
        int i = 0;
        while(true){
            if(i < arr.length && arr[i] == current){
                i++;
            } else {
                missing++;
                if(missing == k){
                    return current;
                }
            }
            current++;
        }
    }
}