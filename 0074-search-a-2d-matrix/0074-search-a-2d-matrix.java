class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       if(matrix.length ==0 || matrix[0].length == 0) return false;

        int n = matrix[0].length - 1;

       for(int i=0; i < matrix.length; i++){
            if(target > matrix[i][n]) continue;

            int start = 0;
            int end = n;

            while(start <= end){
                int mid = (end - start)/2 + start;
                if(matrix[i][mid] == target){
                    return true;
                } else if (matrix[i][mid] > target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
       }
       return false;
    }
}