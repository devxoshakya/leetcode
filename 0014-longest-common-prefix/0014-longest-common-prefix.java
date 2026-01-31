class Solution {
    public String longestCommonPrefix(String[] s) {
        if(s.length == 0) return "";

        StringBuilder prefix = new StringBuilder();

        for(int i=0; i < s[0].length(); i++){
            char c = s[0].charAt(i);
            for(int j=0; j < s.length; j++){
                if(i >= s[j].length() || s[j].charAt(i) != c){
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }
}