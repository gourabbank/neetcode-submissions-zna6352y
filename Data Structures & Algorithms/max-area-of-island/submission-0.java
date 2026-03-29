class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    max=Math.max(max,dfs(i,j,grid));
                }
            }
        }
        return max;
    }
    public int dfs(int r, int c, int[][] grid)
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0)
        {
            return 0;
        }
        grid[r][c]=0;
        return 1+dfs(r+1,c,grid)+dfs(r-1,c,grid)+dfs(r,c+1,grid)+dfs(r,c-1,grid);
    }
}
