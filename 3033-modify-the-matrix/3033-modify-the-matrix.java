class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] ans = new int[n][m];

        int[] col = new int[m];
        Arrays.fill(col, -1);

        // Copy matrix and compute column maximums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = matrix[i][j];
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }

        // Replace -1 with column maximum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans[i][j] == -1) {
                    ans[i][j] = col[j];
                }
            }
        }

        return ans;
    }
}
