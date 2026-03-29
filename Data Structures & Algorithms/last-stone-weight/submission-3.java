class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int s:stones)
        {
            pq.offer(s);
        }
        while(pq.size()>1)
        {
            int x=pq.poll();
            int y=pq.poll();
            pq.offer(Math.abs(x-y));
        }
        return Math.abs(pq.poll());
    }
}
