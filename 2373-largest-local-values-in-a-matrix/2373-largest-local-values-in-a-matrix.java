class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int[][] res = new int[n-2][n-2];

        for(int i=0; i<n-2; i++){
            for(int j=0; j < n-2; j++){
                res[i][j] = findMax(grid,i,j);
            }
        }
        return res;
    }

    private int findMax(int[][] grid, int i, int j){
        int max = 0;
        for(int row = i; row < i + 3; row++ ){
            for(int col = j; col < j + 3; col++){
                if(grid[row][col] > max){
                    max = grid[row][col];
                }
            }
        }
        return max;
    }
}