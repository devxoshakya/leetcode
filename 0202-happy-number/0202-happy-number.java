class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = squareDigits(slow);
            fast = squareDigits(squareDigits(fast));
        } while(slow!=fast);

        return slow == 1;
    }

    private int squareDigits(int num){
        int ans = 0;
        while(num!=0){
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }
        return ans;
    }
}