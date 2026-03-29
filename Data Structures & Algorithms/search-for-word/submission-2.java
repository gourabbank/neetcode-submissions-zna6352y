class Solution {
    boolean flag=false;
    public boolean exist(char[][] board, String word) {
        int idx=0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    dfs(i,j,word,board,0);
                }
            }
        }
        return flag;
    }
    public void dfs(int r, int c, String word, char[][] board, int idx)
    {
        if(flag) return;
        if(idx==word.length())
        {
            flag=true;
            return;
        }
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]==',')
        {
            return;
        }
        char ch=board[r][c];
        if(ch!=word.charAt(idx)) return;
        board[r][c]=',';

        dfs(r+1,c,word,board,idx+1);
        dfs(r-1,c,word,board,idx+1);
        dfs(r,c+1,word,board,idx+1);
        dfs(r,c-1,word,board,idx+1);
        board[r][c]=ch;
    }
}
