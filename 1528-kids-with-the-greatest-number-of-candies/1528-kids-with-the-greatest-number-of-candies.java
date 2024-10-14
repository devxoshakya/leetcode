class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = 0;
        for(int num : candies){
            if(max<num){
                max = num;
            }
        }
        for(int i=0; i<candies.length; i++){
            if((candies[i]+extraCandies) >= max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;

    }
}