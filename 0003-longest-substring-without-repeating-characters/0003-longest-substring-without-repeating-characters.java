class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        int maxLength = Integer.MIN_VALUE;
        int len = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0; int j=0;
        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j)) + 1);
            } 
                map.put(s.charAt(j),j);
                len = j - i + 1;
                maxLength = Math.max(len,maxLength);
            
            j++;
        }
        return maxLength;
        
    }
}