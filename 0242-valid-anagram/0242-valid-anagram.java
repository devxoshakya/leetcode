class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(int i = 0; i  < s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            map1.put(sch, map1.getOrDefault(sch,0)+1);
            map2.put(tch, map2.getOrDefault(tch,0)+1);
        }

        return map1.equals(map2);
    }
}