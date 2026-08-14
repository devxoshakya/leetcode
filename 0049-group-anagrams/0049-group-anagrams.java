class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26];
            for(char ch : s.toCharArray()){
                count[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int i : count){
                key.append(i).append("^");
            }
            String hash = key.toString();

            if(!map.containsKey(hash)){
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(s);
        }

        return new ArrayList<>(map.values());
    }
}