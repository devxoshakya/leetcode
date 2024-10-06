import java.util.*;

class Solution {
    public int maxGoodNumber(int[] nums) {
             List<String> binaryNumbers = new ArrayList<>();
             for(int num: nums){
                binaryNumbers.add(Integer.toBinaryString(num));
             }

             Collections.sort(binaryNumbers, (a,b)-> (b+a).compareTo(a+b));

             StringBuilder result  = new StringBuilder();
             for(String binary: binaryNumbers){
                result.append(binary);
             }

             return Integer.parseInt(result.toString(),2);   
    }

}