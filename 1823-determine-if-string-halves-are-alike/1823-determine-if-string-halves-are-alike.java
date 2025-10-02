class Solution {
    public boolean halvesAreAlike(String s) {
        String a = s.substring(0,s.length()/2);
        String b = s.substring(s.length()/2);
        return vowelCount(a) == vowelCount(b);
    }

    public int vowelCount(String s){
        int count = 0;
        for(int ch = 0; ch < s.length(); ch++){
            if("AEIOUaeiou".indexOf(s.charAt(ch)) != -1){
                count++;
            }
        }
        return count;
    }
}