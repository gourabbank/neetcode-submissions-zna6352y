class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        //[end,number of passengers]
        int currCap=0;
        for(int[] t:trips)
        {
            int numPass=t[0],start=t[1],end=t[2];
            while(!pq.isEmpty() && pq.peek()[0]<=start)
            {
                currCap-=pq.poll()[1];
            }
            currCap+=numPass;
            if(currCap>capacity) return false;
            pq.offer(new int[]{end,numPass});
        }
        return true;
    }
}