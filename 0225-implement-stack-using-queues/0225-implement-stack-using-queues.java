class MyStack {
    Deque<Integer> stack;
    public MyStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.addFirst(x);
    }
    
    public int pop() {
       return stack.pollFirst();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public boolean empty() {
        return stack.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */