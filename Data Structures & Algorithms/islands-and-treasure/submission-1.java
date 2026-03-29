class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    dfs(grid,i,j,0);
                }
            }
        }
    }
    public void dfs(int[][] grid, int i, int j, int dist)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;
        if(grid[i][j]==-1) return;
        if(dist>grid[i][j]) return;
        grid[i][j]=dist;
        dfs(grid,i+1,j,dist+1);
        dfs(grid,i-1,j,dist+1);
        dfs(grid,i,j+1,dist+1);
        dfs(grid,i,j-1,dist+1);
    }
}
