class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int sum = 0;
        int duplicate = 0;
        int n = grid.length;
        Set<Integer> set = new HashSet<>();

        for (int[] row : grid) {
            for (int element : row) {
                if (set.contains(element)) {
                    duplicate = element;
                } else {
                    set.add(element);
                }
                sum += element;
            }
        }

        int total = n * n;
        int expectedSum = (total * (total + 1)) / 2;
        int missing = expectedSum + duplicate - sum;
        return new int[] { duplicate, missing };
    }
}