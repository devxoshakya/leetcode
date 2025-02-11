// class Solution {
//     public int[] searchRange(int[] nums, int target) {
        
//     }
// }
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        
        // Find first and last position using 2 binary searches
        int first = binarySearch(nums, target - 0.5);
        int last = binarySearch(nums, target + 0.5) - 1;
        
        if (first <= last) {
            return new int[]{first, last};
        }
        return new int[]{-1, -1};
    }
    
    private int binarySearch(int[] nums, double target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}