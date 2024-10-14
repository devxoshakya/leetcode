class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
         int i;
        if(ruleKey.equals("type"))i=0;
        else if(ruleKey.equals("color"))i=1;
        else i=2;
        int count=0;
        for(List<String> list :items){
           if(ruleValue.equals(list.get(i))){
            count=count+1;
           }
        }
        return count;
    }
}