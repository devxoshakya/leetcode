class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String tkn : tokens ){
            if(tkn.equals("+") || tkn.equals("*") || tkn.equals("/") || tkn.equals("-")){
                int a = s.pop();
                int b = s.pop();
                int res = operate(a,b,tkn);
                s.push(res); 
            } else {
                s.push(Integer.parseInt(tkn));
            }
        }
        return s.pop();
    }

    private int operate(int a, int b, String op){
        switch(op){
            case "+" :
                return b + a;
            case "-" :
                return b - a;
            case "*" :
                return b * a;
            case "/" :
                return b / a;
        }
        return -1;
    }
}