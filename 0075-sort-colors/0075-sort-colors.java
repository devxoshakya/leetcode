class Solution {
    public void sortColors(int[] arr) {
       int n = arr.length;
        
        for (int i = 0; i < n-1; i++) {
            for(int j=i+1; j>0; j--){
                if (arr[j]<arr[j-1]) {
                    int t = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = t;
                }
            }
        }
    } 
    
}