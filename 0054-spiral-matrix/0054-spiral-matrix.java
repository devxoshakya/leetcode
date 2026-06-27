class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int top = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;

        while (left < right && top < bottom){
            // top row
            for (int i = left; i < right; i++)
                ans.add(matrix[top][i]);
            top++;

            // right column
            for (int i = top; i < bottom; i++)
                ans.add(matrix[i][right - 1]);
            right--;

            if (top >= bottom || left >= right)
                break;

            // bottom row
            for (int i = right - 1; i >= left; i--)
                ans.add(matrix[bottom - 1][i]);
            bottom--;

            // left column
            for (int i = bottom - 1; i >= top; i--)
                ans.add(matrix[i][left]);
            left++;
        }

        return ans;
    }
}