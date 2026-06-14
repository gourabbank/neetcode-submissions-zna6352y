class StockSpanner {
    Stack<Integer> st;
    List<Integer> list;
    public StockSpanner() {
        this.st=new Stack<>();
        this.list=new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int span=0;
        for(int i=list.size()-1;i>=0;i--)
        {
            if(list.get(i)<=price) span++;
            else break;
        }
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */