class Solution {
    public String restoreString(String s, int[] indices) {
        char[] car = new char[indices.length];
        for(int i=0; i<indices.length; i++){
            car[indices[i]] = s.charAt(i);
        }
        return new String(car);  
    }
}