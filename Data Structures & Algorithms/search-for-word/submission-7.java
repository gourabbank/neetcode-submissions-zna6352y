class Solution {
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int cols=board[0].length;
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]==word.charAt(0) && !visited[i][j])
                {
                    if(dfs(i,j,visited,board,word,0)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int r,int c, boolean[][] visited, char[][] board, String word, int idx)
    {
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visited[r][c]) return false;
        
        if(board[r][c]!=word.charAt(idx))
        {
            return false;
        }
        if(idx==word.length()-1) return true;
        visited[r][c]=true;
        
        idx=idx+1;
        boolean found=(dfs(r+1,c,visited,board,word,idx)||
        dfs(r,c+1,visited,board,word,idx)||
        dfs(r-1,c,visited,board,word,idx)||
        dfs(r,c-1,visited,board,word,idx));
        visited[r][c]=false;
        return found;

    }
}
