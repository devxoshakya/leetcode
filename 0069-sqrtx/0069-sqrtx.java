class Solution {
    public int mySqrt(int x) {

        if(x==0) return 0;
        if(x==1) return 1;

        long s = 1;
        long e = x/2;
        while ( s<=e){
            long mid = s + (e-s)/2;
            if(mid*mid == x){
                return (int)mid;
            }
            else if (mid*mid > x){
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return (int)s-1;
    }
}