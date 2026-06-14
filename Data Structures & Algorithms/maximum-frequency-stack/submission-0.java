class FreqStack {
    PriorityQueue<int[]> pq; // val,freq,insertOrder
    Map<Integer,Integer> map;
    int order;
    public FreqStack() {
        this.map=new HashMap<>();
        this.order=0;
        this.pq=new PriorityQueue<>(
            (a,b)->{
                if(a[1]!=b[1]) return b[1]-a[1];
                else return b[2]-a[2];
            }
        );
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        order++;
        pq.offer(new int[]{val,map.get(val),order});
    }
    
    public int pop() {
        int[] top=pq.poll();
        map.put(top[0],map.get(top[0])-1);
        return top[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */