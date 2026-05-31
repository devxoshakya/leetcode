class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Integer> sm = new HashMap<>();
        Map<Character,Integer> tm = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            sm.put(sch,sm.getOrDefault(sch,0)+1);
            tm.put(tch,tm.getOrDefault(tch,0)+1);
        }

        return sm.equals(tm);

    }
}