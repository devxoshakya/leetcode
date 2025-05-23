class Solution {
    public int diagonalSum(int[][] mat) {
       int sum =0;
        int m=mat.length;
        for(int i=0;i<m;i++){
            sum += mat[i][i] + mat[i][m-i-1];
        }
        if(m % 2 != 0) 
            sum -= mat[m/2][m/2];
        return sum;
    }
}