class Solution {
    public int titleToNumber(String columnTitle) {
        int count = 0;
        for(char ch : columnTitle.toCharArray()){
            int temp = ch - 'A' + 1;
            count = count * 26 + temp;
        }

        return count;
    }
}