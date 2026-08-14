class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();
        for(int i=0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            m1.put(c1,m1.getOrDefault(c1,0)+1);
            m2.put(c2,m2.getOrDefault(c2,0)+1);
        }
        return m1.equals(m2);
    }
}