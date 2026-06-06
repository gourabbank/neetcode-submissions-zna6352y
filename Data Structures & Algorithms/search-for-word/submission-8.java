class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(i,j,board,word,visited,0)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int r, int c, char[][] board, String word, boolean[][] visited, int idx)
    {
        if(idx==word.length()) return true;
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visited[r][c])
        {
            return false;
        }
        if(board[r][c]!=word.charAt(idx)) return false;
        visited[r][c]=true;
        boolean flag= dfs(r+1,c,board,word,visited,idx+1) ||
        dfs(r-1,c,board,word,visited,idx+1) || 
        dfs(r,c+1,board,word,visited,idx+1) || 
        dfs(r,c-1,board,word,visited,idx+1);
        visited[r][c]=false;
        return flag;
    }
}
