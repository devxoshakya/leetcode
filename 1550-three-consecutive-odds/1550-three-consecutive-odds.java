class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int odds = 0;
        for(int x : arr){
            if(odds >= 3) break;
            if(x % 2 != 0){
                odds++; 
            } else {
                odds = 0;
            }
        }
        return odds >= 3;
    }
}