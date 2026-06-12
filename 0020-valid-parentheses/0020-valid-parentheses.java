class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }

            if(ch == ')' || ch == ']' || ch == '}'){
                if(stack.isEmpty()) return false;

                char popped = stack.pop();

                 if(ch == ')' && popped != '('){
                    return false;
                }
                if(ch == '}' && popped != '{'){
                    return false;
                }
                if(ch == ']' && popped != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}