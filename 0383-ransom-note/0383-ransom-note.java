class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c) || map.get(c) < 1) return false;
            map.put(c,map.get(c) - 1);
        }
        return true;
    }
}