class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        int minVal = Math.min(value, minStack.isEmpty() ? value : minStack.peek());
        minStack.push(minVal); 
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek(); 
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */