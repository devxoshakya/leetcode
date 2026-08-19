class Solution {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        StringBuilder res = new StringBuilder();
        for(int i=0; i < bin.length(); i++){
            if(bin.charAt(i) == '0'){
                res.append("1");
            } else {
                res.append("0");
            }
        }

        return Integer.parseInt(res.toString(), 2);
    }
}