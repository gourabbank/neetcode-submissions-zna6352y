class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->dist(b[0],b[1])-dist(a[0],a[1])
        );
        for(int[] p:points)
        {
            pq.offer(new int[]{p[0],p[1]});
            while(pq.size()>k)
            {
                pq.poll();
            }
        }
        int[][] sol=new int[k][2];
        for(int i=0;i<k;i++)
        {
            sol[i]=pq.poll();
        }
        return sol;

    }
    
    public int dist(int x, int y)
    {
        return (x*x + y*y);
    }
}
