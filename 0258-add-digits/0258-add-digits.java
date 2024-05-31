class Solution {
    public int addDigits(int num) {
        int check = (int)Math.log10(num) + 1;
        if(check<=1){
            return num;
        }
        int res = 0;
        while(num!=0){
            res += num%10;
            num /= 10;
        }
        return addDigits(res);
    }
}