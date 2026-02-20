class Solution {
    public String longestPrefix(String s) {
        int dp[] = new int[s.length()], j = 0;
    for (int i = 1; i < s.length(); ++i) {
        if (s.charAt(i) == s.charAt(j))
            dp[i] = ++j;
        else if (j > 0) {
            j = dp[j - 1];
            --i;
        }
    }
    return s.substring(0, j);   
    }
}