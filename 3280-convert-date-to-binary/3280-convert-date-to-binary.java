class Solution {
    public String convertDateToBinary(String date) {
        String[] words = date.split("-");

        StringBuilder ans = new StringBuilder();
        for (String s : words) {
            ans.append(Integer.toBinaryString(Integer.parseInt(s)));
            ans.append("-");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();

    }
}