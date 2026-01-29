class Solution {
    public int candy(int[] rating) {
        int[] candy = new int[rating.length];
        Arrays.fill(candy,1);

        for(int i=1; i<candy.length; i++){
            if(rating[i] > rating[i-1]){
                candy[i] = candy[i-1] + 1; 
            }
        }

        for(int i = candy.length-2; i >=0; i--){
            if(rating[i] > rating[i+1]){
                candy[i] = Math.max(candy[i],candy[i+1]+1);
            }
        }

        return Arrays.stream(candy).sum();
    }
}