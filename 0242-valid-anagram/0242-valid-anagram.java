class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char s1 = s.charAt(i);
            char s2 = t.charAt(i);
            m1.put(s1, m1.getOrDefault(s1,0)+1);
            m2.put(s2, m2.getOrDefault(s2,0)+1);
        }
        return m1.equals(m2);
    }
}