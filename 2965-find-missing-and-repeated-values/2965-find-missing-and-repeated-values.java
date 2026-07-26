class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int sum = 0;
        int duplicate = -1;
        int n = grid.length;

        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++ ){
            for(int j = 0; j < n; j++){
                int curr = grid[i][j];
                if(set.contains(curr)){
                    duplicate = curr;
                }
                set.add(curr);
                sum += curr;
            }
        }

        int total = n * n;
        int expectedSum = (total * (total + 1)) / 2;
        int missing = expectedSum + duplicate - sum;
        return new int[] { duplicate, missing };
    }
}