class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                freq[ch - 'a']++;
            }

            StringBuilder hash = new StringBuilder();
            for (int j : freq) {
                hash.append(j).append("#");
            }

            String key = hash.toString();

            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}