class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    ans=Math.max(dfs(i,j,grid,visited),ans);
                }
            }
        }
        return ans;
    }
    public int dfs(int i, int j, int[][] grid, boolean[][] visited)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return 0;
        if(visited[i][j]) return 0;
        visited[i][j]=true;
        return 1+dfs(i+1,j,grid,visited)+dfs(i-1,j,grid,visited)+dfs(i,j+1,grid,visited)+dfs(i,j-1,grid,visited);
    }
}
