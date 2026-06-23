class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = ( rows * cols) - 1;

        while( left <= right){
            int mid = (right - left) + left/2;
            int val = matrix[mid/cols][mid%cols];

            if(val == target){
                return true;
            } else if (val < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}