class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for(int price : prices){
            if(minPrice >= price){
                minPrice = price;
            }

            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}