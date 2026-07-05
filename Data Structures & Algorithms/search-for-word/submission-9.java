class Solution {
    int m,n;
    public boolean exist(char[][] board, String word) {
        this.m=board.length;
        this.n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(0,i,j,board,word,visited)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int idx, int r, int c, char[][] board, String word, boolean[][] visited)
    {
        if(idx==word.length())
        {
            return true;
        }
        if(r<0 || c<0 || r>=board.length || c>=board[0].length)
        {
            return false;
        }
        if(visited[r][c] || board[r][c]!=word.charAt(idx)) return false;
        visited[r][c]=true;
        boolean found=dfs(idx+1, r+1,c,board,word,visited) ||
            dfs(idx+1, r-1,c,board,word,visited) ||
            dfs(idx+1, r,c+1,board,word,visited) ||
            dfs(idx+1, r,c-1,board,word,visited);
        visited[r][c]=false;
        return found;
    }
}
