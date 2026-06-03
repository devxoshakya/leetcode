class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int idx = 0;
        int i = 0;

        while (i < n) {
            char current = chars[i];
            int count = 0;
            while(i < n && chars[i] == current){
                count++;
                i++;
            }

            chars[idx++] = current;

            if(count > 1){
                String countStr = String.valueOf(count);
                for(char ch : countStr.toCharArray()){
                    chars[idx++] = ch;
                }
            }
        }

        return idx;
    }
}