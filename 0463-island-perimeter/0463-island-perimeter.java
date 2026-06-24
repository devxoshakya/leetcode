class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    if (r == 0 || grid[r - 1][c] == 0)
                        count++;
                    if (r == grid.length - 1 || grid[r + 1][c] == 0)
                        count++;
                    if (c == 0 || grid[r][c - 1] == 0)
                        count++;
                    if (c == grid[0].length - 1 || grid[r][c + 1] == 0)
                        count++;
                }
            }
        }
        return count;
    }
}