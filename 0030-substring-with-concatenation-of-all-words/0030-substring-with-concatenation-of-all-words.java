class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) return ans;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        // We try starting from each offset [0 .. wordLen-1]
        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, right = offset;
            Map<String, Integer> window = new HashMap<>();
            int matched = 0;

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (!freq.containsKey(word)) {
                    window.clear();
                    matched = 0;
                    left = right;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0) + 1);
                matched++;

                while (window.get(word) > freq.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    matched--;
                    left += wordLen;
                }

                if (matched == wordCount) {
                    ans.add(left);
                }
            }
        }

        return ans;
    }
}
