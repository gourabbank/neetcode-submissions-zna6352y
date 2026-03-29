class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int []> pq=new ArrayList<>();
        for(int i[]:intervals)
        {
            if(!pq.isEmpty())
            {
                int interval[]=pq.getLast();
                if(i[0]<=interval[1])
                {
                    pq.removeLast();
                    pq.add(new int[]{interval[0],Math.max(i[1],interval[1])});
                }
                else
                {
                    pq.add(new int[]{i[0],i[1]});
                }
            }
            else
            {
                pq.add(new int[]{i[0],i[1]});
            }
        }
        return pq.toArray(new int[pq.size()][]);
    }
}
