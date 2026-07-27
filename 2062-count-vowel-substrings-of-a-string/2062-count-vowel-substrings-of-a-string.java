class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' 
                || ch == 'o' || ch == 'u';
    }

    public int countVowelSubstrings(String word) {
        char str[] = word.toCharArray();
        return atLeastKConst(str, 0) - atLeastKConst(str, 1);
    }

    public int atLeastKConst(char[] str, int k) {
        int n = str.length, ans = 0;
        int[] freq = new int[26];
        int vow = 0, cons = 0;
        for(int i = 0, j = 0; i < n; i++) {
            if(isVowel(str[i]))
                vow += freq[str[i]-'a']++ == 0 ? 1 : 0;
            else
                cons++;
            while(vow >= 5 && cons >= k) {
                ans += n - i;
                if(isVowel(str[j]))
                    vow -= --freq[str[j]-'a'] == 0 ? 1 : 0;
                else
                    cons--;
                j++;
            }
        }
        return ans;
    }
}