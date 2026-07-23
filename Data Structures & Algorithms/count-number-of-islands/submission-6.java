class Solution {
    int m,n;
    public int numIslands(char[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        int res=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(i,j,grid);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int r, int c, char[][] grid)
    {
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]=='0') return;
        grid[r][c]='0';
        dfs(r-1,c,grid);
        dfs(r+1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }
}
