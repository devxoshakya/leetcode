class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        
        int i = ruleKey.equals("type") ? 0 : (ruleKey.equals("color") ? 1 : 2);
        int count = 0;
        for(List<String> list :items){
           if(ruleValue.equals(list.get(i))){
            count++;
           }
        }
        
        return count;
    }
}