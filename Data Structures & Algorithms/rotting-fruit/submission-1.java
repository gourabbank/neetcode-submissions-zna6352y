class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    fresh++;
                }
                else if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j});
                }
            }
        }
        if(fresh==0) return 0;
        int time=0;
        int dirs[][]=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] curr=q.poll();
                for(int[] d:dirs)
                {
                    int nr=d[0]+curr[0];
                    int nc=d[1]+curr[1];
                    if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length) continue;
                    if(grid[nr][nc]!=1)continue;
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr,nc});
                }
            }
            time++;
        }
        return fresh==0?time-1:-1;
    }
}
