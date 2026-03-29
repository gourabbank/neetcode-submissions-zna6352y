class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq=new PriorityQueue<>();
        this.k=k;
        for(int n:nums)
        {
            pq.offer(n);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size()>k)
        {
            pq.poll();
        }
        return pq.peek();
    }
}
