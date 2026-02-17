class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum = 0;
        for(int i : cardPoints){
            maxSum += i;
        }

        int windowLen = cardPoints.length - k;
        int window = 0;
        for(int i=0; i < windowLen; i++){
            window += cardPoints[i];
        }
        int result = maxSum - window;
        int start = 0;
        int end = windowLen;
        while(end < cardPoints.length){
            window = window + cardPoints[end++] - cardPoints[start++];
            result = Math.max(result,maxSum - window);
        }

        return result;

    }
}