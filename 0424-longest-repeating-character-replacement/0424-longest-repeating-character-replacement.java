class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int left = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            map.put(s.charAt(right),
                    map.getOrDefault(s.charAt(right), 0) + 1);

            while ((right - left + 1) - maxFreq(map) > k) {
                map.put(s.charAt(left),
                        map.get(s.charAt(left)) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public int maxFreq(HashMap<Character, Integer> map) {
        int maxFrequency = 0;

        for (int value : map.values()) {
            maxFrequency = Math.max(maxFrequency, value);
        }

        return maxFrequency;
    }
}