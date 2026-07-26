class Solution {
    public double myPow(double x, int n) {
        long temp = n;

        if(temp < 0) return 1.0 / power(x,-temp);

        return power(x,temp); 
    }

    private double power(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;

        if(n % 2 == 0) return power(x*x, n /2);

        return x * power(x,n-1);
    }
}