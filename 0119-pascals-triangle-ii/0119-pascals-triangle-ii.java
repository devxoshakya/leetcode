class Solution {
    public List<Integer> getRow(int numRows) {
         List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if(numRows == 0) return firstRow;

        for(int i=1; i <= numRows; i++){
            List<Integer> prevRow = result.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            for(int j = 1; j < i; j++){
                currentRow.add(prevRow.get(j-1) + prevRow.get(j));
            }

            currentRow.add(1);
            result.add(currentRow);
        }

        return result.get(result.size()-1);
    }
}