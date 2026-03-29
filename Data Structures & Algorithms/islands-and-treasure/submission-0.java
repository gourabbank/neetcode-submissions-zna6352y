class Solution {
    int inf=Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    dfs(i,j,grid,0);
                }
            }
        }
    }
    public void dfs(int r, int c, int[][] grid, int dist)
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length )
        {
            return;
        }
        if(grid[r][c]==-1) return;
        if(dist>grid[r][c]) return;
        grid[r][c]=dist;
        dfs(r+1,c,grid,dist+1);
        dfs(r-1,c,grid,dist+1);
        dfs(r,c+1,grid,dist+1);
        dfs(r,c-1,grid,dist+1);
    }
}
