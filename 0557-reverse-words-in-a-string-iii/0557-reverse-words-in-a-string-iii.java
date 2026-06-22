class Solution {
    public String reverseWords(String s) {
        StringBuilder si = new StringBuilder("");
        String strings[] = s.split(" ");
        for(String str : strings){
            si.append(rev(str)).append(" ");
        }
        return si.toString().trim();
        
    }

    private String rev(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    

}