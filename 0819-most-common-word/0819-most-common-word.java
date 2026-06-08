class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : banned) {
            ban.add(s);
        }

        paragraph = paragraph.toLowerCase()
                             .replaceAll("[!?',;.]", " ");

        String[] words = paragraph.split("\\s+");

        String result = "";
        int maxFreq = 0;

        for (String word : words) {
            if (!ban.contains(word)) {
                int freq = map.getOrDefault(word, 0) + 1;
                map.put(word, freq);

                if (freq > maxFreq) {
                    maxFreq = freq;
                    result = word;
                }
            }
        }

        return result;
    }
}