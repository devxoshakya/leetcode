class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for(int i=0; i < s.length()-1; i++){
            int a = s.charAt(i);
            int b = s.charAt(i+1);
            score += Math.abs(a-b);
        }
        return score;
    }
}