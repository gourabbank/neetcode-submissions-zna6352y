class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->dist(b)-dist(a)
        );
        for(int p[]:points)
        {
            pq.offer(p);
            if(pq.size()>k) pq.poll();
        }
        int[][] sol=new int[k][2];
        for(int i=0;i<k;i++)
        {
            sol[i]=pq.poll();
        }
        return sol;

    }
    public int dist(int[] p)
    {
        return ((p[0]*p[0]) + (p[1]*p[1]));
    }
}
