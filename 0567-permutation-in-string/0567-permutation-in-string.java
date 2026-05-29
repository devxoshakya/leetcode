class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int s1count[] = new int[26];
        int s2count[] = new int[26];
        Arrays.fill(s1count,0);
        Arrays.fill(s2count,0);

        for(int i = 0 ; i < s1.length(); i++){
            s1count[s1.charAt(i) - 'a'] += 1;
            s2count[s2.charAt(i) - 'a'] += 1;
        }
        int matches = 0;
        for(int i=0; i < 26; i++){
            matches += s1count[i] == s2count[i] ? 1 : 0;
        }
        int left = 0;
        for(int right = s1.length(); right < s2.length(); right++){
            if(matches == 26) return true;
            int idx = s2.charAt(right) - 'a';
            s2count[idx] += 1;
            if(s1count[idx] == s2count[idx]){
                matches++;
            } else if (s1count[idx] + 1 == s2count[idx]){
                matches--;
            }

            int idx2 = s2.charAt(left) - 'a';
            s2count[idx2] -= 1;
            if(s1count[idx2] == s2count[idx2]){
                matches++;
            } else if (s1count[idx2] - 1 == s2count[idx2]){
                matches--;
            }
            left++;
        }
        return matches == 26;
    }
}