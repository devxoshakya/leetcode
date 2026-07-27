class Solution {
    public boolean areNumbersAscending(String s) {
        int previousNumber = -1;
        
        // 1. Split by spaces to isolate words and numbers
        for (String token : s.split(" ")) {
            // 2. Check if the current token is a number
            if (Character.isDigit(token.charAt(0))) {
                int currentNumber = Integer.parseInt(token);
                
                // 3. Verify strictly ascending order
                if (currentNumber <= previousNumber) {
                    return false;
                }
                previousNumber = currentNumber;
            }
        }
        return true;
    }
}
