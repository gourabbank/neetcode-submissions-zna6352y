class FreqStack {
    Map<Integer,Integer> map;
    Map<Integer,Stack<Integer>> stacks;
    int maxCnt;
    public FreqStack() {
        this.map=new HashMap<>();
        this.stacks=new HashMap<>();
        this.maxCnt=0;
    }
    
    public void push(int val) {
        int freq=map.getOrDefault(val,0)+1;
        map.put(val,freq);
        if(freq>maxCnt)
        {
            maxCnt=freq;
            stacks.putIfAbsent(freq,new Stack<>());
        }
        stacks.get(freq).push(val);
    }
    
    public int pop() {
        int res=stacks.get(maxCnt).pop();
        map.put(res,map.get(res)-1);
        if(stacks.get(maxCnt).isEmpty())
        {
            maxCnt--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */