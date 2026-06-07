class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> sol=new ArrayList<>();
        int[] prev=intervals[0];
        sol.add(prev);
        for(int i=1;i<intervals.length;i++)
        {
            prev=sol.getLast();
            if(prev[1]<intervals[i][0])
            {
                sol.add(intervals[i]);
            }
            else
            {
                if(!sol.isEmpty())
                {
                    sol.removeLast();
                    prev[1]=Math.max(prev[1],intervals[i][1]);
                    sol.add(prev);
                }
            }
        }
        return sol.toArray(new int[sol.size()][]);
    }
}
