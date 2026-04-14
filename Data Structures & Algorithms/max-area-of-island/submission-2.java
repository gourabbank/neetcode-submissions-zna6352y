class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visited=new boolean[rows][cols];
        int area=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==1) area=Math.max(dfs(grid,i,j),area);
            }
        }
        return area;
    }
    public int dfs(int [][] grid, int r, int c)
    {
        if(r<0 || c<0 || r>=grid.length || c>= grid[0].length || grid[r][c]==0)
        {
            return 0;
        }
        grid[r][c]=0;
        return 1+dfs(grid,r+1,c)+dfs(grid,r-1,c)+dfs(grid,r,c+1)+dfs(grid,r,c-1);
    }
}
