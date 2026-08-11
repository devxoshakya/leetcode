class NumMatrix {
    int sumMat[][];
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sumMat = new int[row+1][col+1];
        for (int[] ro : sumMat) {
            Arrays.fill(ro, 0);
        }
        for(int i = 0; i < row; i++){
            int prefix = 0;
            for(int j = 0; j < col; j++){
                prefix += matrix[i][j];
                int above = sumMat[i][j+1];
                sumMat[i+1][j+1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMat[row2 + 1][col2 + 1]
                - sumMat[row2 + 1][col1]
                - sumMat[row1][col2 + 1]
                + sumMat[row1][col1];

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */