class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for(int price : prices){
            if(price < minVal){
                minVal = price;
            }
            maxProfit = Math.max(maxProfit, price - minVal);
        }
        return maxProfit;

    }
}