class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> count = new HashMap<>();

        for(char ch : s.toCharArray()){
            count.put(ch,count.getOrDefault(ch,0)+1);
        }

        int length = 0;
        boolean isOdd = false;

        for(int i : count.values()){
            if(i % 2 == 0){
                length += i;
            } else {
                length += i - 1;
                isOdd = true;
            }
        }

        if(isOdd){
            length += 1;
        }

        return length;
    }
}