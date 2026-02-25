class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs[0].length();
        StringBuilder res = new StringBuilder();
        for(int i=0; i < len; i++){
            for(String s : strs){
                if(i == s.length() || s.charAt(i) != strs[0].charAt(i)){
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
        
    }
}