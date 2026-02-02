class Solution {
    public boolean isSubsequence(String s, String t) {
        int cs = 0;
        int ct = 0;
        while(ct < t.length() && cs < s.length()){
            if(s.charAt(cs) == t.charAt(ct)){
                cs++;
            }
            ct++;
        }
        return cs == s.length();
    }
}