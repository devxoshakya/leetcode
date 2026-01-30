class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new LinkedHashMap<>() {{
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }};

        StringBuilder res = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();

            while (num >= value) {
                res.append(symbol);
                num -= value;
            }
        }
        return res.toString();
    }
}
