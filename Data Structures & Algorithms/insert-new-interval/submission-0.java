class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> sol=new ArrayList<>();
        int start=newInterval[0];
        int end=newInterval[1];
        int i=0,n=intervals.length;
        while(i<n && intervals[i][1]<start)
        {
            sol.add(intervals[i]);
            i++;
        }
        while(i<n && end>=intervals[i][0])
        {
            start=Math.min(start,intervals[i][0]);
            end=Math.max(end,intervals[i][1]);
            i++;
        }
        sol.add(new int[]{start,end});
        while(i<n)
        {
            sol.add(intervals[i]);
            i++;
        }
        return sol.toArray(new int[sol.size()][]);
    }
}
