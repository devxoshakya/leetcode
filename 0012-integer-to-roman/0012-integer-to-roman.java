class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new LinkedHashMap<>() {
            {
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
            }
        };

        String res = "";
        for (int i : romanMap.keySet()) {
            if (num / i != 0) {
                int count = num / i;
                res += romanMap.get(i).repeat(count);
                num %= i;
            }
        }
        return res;

    }
}