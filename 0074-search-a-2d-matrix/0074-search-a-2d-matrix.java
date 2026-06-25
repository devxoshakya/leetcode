class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int n = matrix[0].length - 1;

        for (int row = 0; row < matrix.length; row++) {

            if (target > matrix[row][n])
                continue;

            int start = 0;
            int end = n;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return false;
    }
}