class Solution {
    public boolean detectCapitalUse(String word) {
        int upper = 0;
        int lower = 0;
        int size = word.length();
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)){
                upper++;
            }
            if(Character.isLowerCase(ch)){
                lower++;
            }
        }
        if(lower == size) return true;
        if(upper == size) return true;
        if(upper == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') return true;
        return false; 
    }
}