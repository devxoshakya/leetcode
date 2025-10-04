class Solution {
    public String reverseWords(String s) {
        StringBuilder si = new StringBuilder("");
        String arr[] = s.split(" ");
        for(String st: arr){
            si.append(rev(st) + " ");
        }
        return si.toString().trim();
    }

    public String rev(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

}