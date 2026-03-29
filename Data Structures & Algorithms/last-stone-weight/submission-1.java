class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int s:stones)
        {
            pq.offer(s);
        }
        while(pq.size()>1)
        {
            pq.offer((Math.abs(pq.poll()-pq.poll())));
        }
        return pq.poll();
    }
}
