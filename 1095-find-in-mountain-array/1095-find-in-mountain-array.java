/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peaks = peak(mountainArr);
        int res = bs_fw(mountainArr, target, peaks);
        if(res==-1){
            res = bs_ds(mountainArr, target, peaks);
        }
        return res;
    }
    static int peak(MountainArray arr){
    int start = 0;
        int end = arr.length()-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr.get(mid)>arr.get(mid+1)){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return end;
}

static int bs_fw(MountainArray arr, int x, int last)
    {
        int l = 0, r = last;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            // Check if x is present at mid
            if (arr.get(m) == x)
                return m;
 
            // If x greater, ignore left half
            if (arr.get(m) < x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
        return -1;
 
    }
static int bs_ds(MountainArray arr, int x, int start)
    {
        int l = start, r = arr.length() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            // Check if x is present at mid
            if (arr.get(m) == x)
                return m;
 
            // If x greater, ignore left half
            if (arr.get(m) > x)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
    return -1;
 
    }
}

