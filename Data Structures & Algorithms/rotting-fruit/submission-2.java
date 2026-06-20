class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int time=0;
        int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty())
        {
            time++;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] curr=q.poll();
                int x=curr[0], y=curr[1];
                for(int[] d:dirs)
                {
                    int nx=x+d[0];
                    int ny=y+d[1];
                    if(nx<0 || ny<0 || nx>=m || ny>=n || grid[nx][ny]==0 || grid[nx][ny]==2) continue;
                    if(grid[nx][ny]==1) grid[nx][ny]=2;
                    q.offer(new int[]{nx,ny});
                    fresh--;
                }
            }
        }
        return fresh==0?time-1:-1;
    }
}
