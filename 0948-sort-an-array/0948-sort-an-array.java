class Solution {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    private void mergeSort(int[] a, int l, int r, int[] temp){
        if(l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(a, l, mid, temp);
        mergeSort(a, mid + 1, r, temp);
        merge(a, l, mid, r, temp);
    }

    private void merge(int[] a, int l, int mid, int r, int[] temp){
        int i = l, j = mid + 1, k = l;
        while(i <= mid && j <= r){
            if(a[i] <= a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        while(i <= mid) temp[k++] = a[i++];
        while(j <= r) temp[k++] = a[j++];
        for(k = l; k <= r; k++){
            a[k] = temp[k];
        }
    }
}