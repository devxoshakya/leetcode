class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;

        long s=0;
       long e=x;
       while(s<=e){
       long mid =s+(e-s)/2;
        if(mid*mid>x){
            e=mid-1;
        } else{
            s=mid+1;
        }
       }
       return (int)s-1;
    }
}