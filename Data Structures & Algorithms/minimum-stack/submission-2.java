class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;
    public MinStack() {
        this.st=new Stack<>();
        this.minSt=new Stack<>();
        this.min=0;
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty()) minSt.push(val);
        else
        {
            minSt.push(Math.min(val,minSt.peek()));
        }
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
