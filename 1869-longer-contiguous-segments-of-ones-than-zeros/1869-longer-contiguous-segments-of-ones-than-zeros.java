class Solution {
    public boolean checkZeroOnes(String s) {
        int zeroes = maxCount(s, '0');
        int ones = maxCount(s, '1');
        return zeroes < ones;
    }

    private int maxCount(String s, char ch) {
        int count = Integer.MIN_VALUE;
        int i = 0;
        while (i < s.length()) {
            int max = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                max++;
                i++;
            }
            count = Math.max(max, count);
            i++;
        }
        return count;
    }
}