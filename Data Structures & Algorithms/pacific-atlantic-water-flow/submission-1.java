class Solution {
    int m;
    int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> sol=new ArrayList<>();
        m=heights.length;
        n=heights[0].length;
        boolean[][] atlantic=new boolean[m][n];
        boolean[][] pacific=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            dfs(i,0,heights,heights[i][0],pacific);
            dfs(i,n-1,heights,heights[i][n-1],atlantic);
        }
        for(int i=0;i<n;i++)
        {
            dfs(0,i,heights,heights[0][i],pacific);
            dfs(m-1,i,heights,heights[m-1][i],atlantic);
        }
        for(int r=0;r<m;r++)
        {
            for(int c=0;c<n;c++)
            {
                if(atlantic[r][c] && pacific[r][c])
                {
                    sol.add(Arrays.asList(r,c));
                }
            }
        }
        return sol;
    }
    public void dfs(int r, int c, int[][] heights, int prev, boolean[][] visited)
    {
        if(r<0 || c<0 || r>=m || c>=n) return;
        if(visited[r][c]) return;
        if(heights[r][c]<prev) return;
        visited[r][c]=true;
        dfs(r+1,c,heights,heights[r][c],visited);
        dfs(r-1,c,heights,heights[r][c],visited);
        dfs(r,c+1,heights,heights[r][c],visited);
        dfs(r,c-1,heights,heights[r][c],visited);
    }
}
