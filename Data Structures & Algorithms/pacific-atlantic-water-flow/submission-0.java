class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length,cols=heights[0].length;
        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];
        List<List<Integer>> sol=new ArrayList<>();
        for(int r=0;r<rows;r++)
        {
            dfs(r,0,heights,heights[r][0],pacific);
        }
        for(int c=0;c<cols;c++)
        {
            dfs(0,c,heights,heights[0][c],pacific);
        }
        for(int r=0;r<rows;r++)
        {
            dfs(r,cols-1,heights,heights[r][cols-1],atlantic);
        }
        for(int c=0;c<cols;c++)
        {
            dfs(rows-1,c,heights,heights[rows-1][c],atlantic);
        }
        for(int r=0;r<rows;r++)
        {
            for(int c=0;c<cols;c++)
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
        if(r<0 || c<0 || r>=heights.length || c>=heights[0].length) return;
        if(visited[r][c]) return;
        if(heights[r][c]<prev) return;
        visited[r][c]=true;
        dfs(r+1,c,heights,heights[r][c],visited);
        dfs(r-1,c,heights,heights[r][c],visited);
        dfs(r,c+1,heights,heights[r][c],visited);
        dfs(r,c-1,heights,heights[r][c],visited);
    }
}
