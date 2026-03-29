class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;
    public MinStack() {
        this.stack=new Stack<>();
        this.minStack=new Stack<>();
        this.min=0;
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()) minStack.push(val);
        else
        {
            minStack.push(Math.min(val,minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
