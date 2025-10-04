class Solution {
    public boolean judgeCircle(String moves) {
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i < moves.length(); i++){
            char current = moves.charAt(i);
            switch(current){
                case 'U' : count1++;
                break;
                case 'D' : count1--;
                break;
                case 'R' : count2++;
                break;
                case 'L' : count2--;
                break;
                default :
                break;
            }
        }
        return count1 == 0 && count2 == 0;
    }
}