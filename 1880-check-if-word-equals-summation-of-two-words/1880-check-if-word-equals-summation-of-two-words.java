class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = getVal(firstWord);
        int second = getVal(secondWord);
        int third = getVal(targetWord);

        return (first + second) == third;

    }

     private int getVal(String word) {
        int sum = 0;
        for (char ch : word.toCharArray()) {
            // Shift existing digits left and add the new digit (0-9)
            sum = sum * 10 + (ch - 'a');
        }
        return sum;
    }
}