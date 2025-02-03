class Solution {
    public int arrangeCoins(int n) {
        if(n<=1){
            return n;
        }
        if(n<=3){
            return n==3?2:1;
        }

        long s = 2;
        long e = n/2;
        while(s<=e){
            long mid = (e-s)/2 +s;
            long coins = (mid*(mid+1))/2;
            if(coins==n){
                return (int)mid;
            }
            if(coins>n){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return (int)e;
    }
}