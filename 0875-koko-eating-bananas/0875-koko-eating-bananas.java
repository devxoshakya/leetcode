public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int pile : piles){
            right = Math.max(right,pile);
        }
        int res = right;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(canFinish(piles,h,mid)){
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for(int pile : piles){
            hours += pile  / k;
            if(pile%k != 0) hours++;
        }
        return hours <= h;
    }
}