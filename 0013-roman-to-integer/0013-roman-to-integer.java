class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int num = 0;
        int i = 0;

        while (i < s.length()) {
            int a = map.get(s.charAt(i));

            if (i + 1 < s.length()) {
                int b = map.get(s.charAt(i + 1));

                if (a < b) {
                    num += b - a;
                    i += 2;
                    continue;
                }
            }

            num += a;
            i++;
        }

        return num;
    }
}
