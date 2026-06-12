class MyStack {
    Queue<Integer> q;
    Queue<Integer> rev;
    public MyStack() {
        this.q=new LinkedList<>();
        this.rev=new LinkedList<>();
    }
    
    public void push(int x) {
        rev.offer(x);
        while(!q.isEmpty())
        {
            rev.offer(q.poll());
        }
        Queue<Integer> temp=q;
        q=rev;
        rev=temp;
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
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