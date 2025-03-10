class Solution {
    public boolean isPalindrome(int x) {
        if(x>=0){
            return (x==rev(x));
        }
        
        return false;
    }
    private int rev(int n){
        int sum = 0;
        while(n>0){
            int rem = n%10;
            sum = sum*10 + rem;
            n = n/10;
        }
        return sum;
    }
}