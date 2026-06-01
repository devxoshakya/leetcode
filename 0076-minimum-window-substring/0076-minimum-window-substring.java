class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character,Integer> countT = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        int res[] = {-1,-1};
        int len = Integer.MAX_VALUE; 

        for(char ch : t.toCharArray()){
            countT.put(ch,countT.getOrDefault(ch,0)+1);
        }

        int have = 0; int need = countT.size();
        int l = 0;
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            window.put(c,window.getOrDefault(c,0)+1);

            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have++;
            }

            while(have == need){
                if(i-l+1 < len){
                    res[0] = l;
                    res[1] = i;
                    len = i - l + 1;
                }
                char key = s.charAt(l);
                window.put(key,window.get(key) - 1);
                if(countT.containsKey(key) && window.get(key) < countT.get(key)){
                    have--;
                }
                l++; 
            }

        }
            return len != Integer.MAX_VALUE ? s.substring(res[0],res[1]+1) : "";

    }
}