class Solution {
    public String sortSentence(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        String[] ans = new String[arr.length]; 

        for(String si : arr){
            String[] res = removeLast(si);
            ans[Integer.parseInt(res[1]) - 1] = res[0];
        }

        for(int i = 0; i < ans.length; i++){
            sb.append(ans[i]);
            if(i != ans.length - 1) sb.append(" ");
        }

        return sb.toString();
    }

    public String[] removeLast(String s){
        String num = String.valueOf(s.charAt(s.length() - 1));
        String clean = s.substring(0, s.length() - 1); 
        return new String[] {clean, num};
    }
}
