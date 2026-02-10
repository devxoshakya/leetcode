class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        if (s.equals(t))
            return s;

        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int count = 0;

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) >= 0) {
                count++;
            }

            while (count == t.length()) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    minStart = l;
                }

                char left = s.charAt(l);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) > 0) {
                        count--;
                    }
                }
                l++;
            }
            r++;

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart + minLength);

    }
}