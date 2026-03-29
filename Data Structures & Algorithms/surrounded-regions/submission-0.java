class Solution {
    public void solve(char[][] board) {
        int rows=board.length,cols=board[0].length;
        boolean[][] visited=new boolean[rows][cols];
        for(int r=0;r<rows;r++)
        {
            if(board[r][0]=='O')
            {
                dfs(r,0,board,visited);
            }
        }
        for(int r=0;r<rows;r++)
        {
            if(board[r][cols-1]=='O')
            {
                dfs(r,cols-1,board,visited);
            }
        }
        for(int c=0;c<cols;c++)
        {
            if(board[0][c]=='O')
            {
                dfs(0,c,board,visited);
            }
        }
        for(int c=0;c<cols;c++)
        {
            if(board[rows-1][c]=='O')
            {
                dfs(rows-1,c,board,visited);
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(board[i][j]=='#')
                {
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(int r, int c, char[][] board,boolean[][] visited)
    {
        if(r<0 || c<0 || r>=board.length || c>=board[0].length) return;
        if(board[r][c]=='X') return;
        if(visited[r][c]) return;
        visited[r][c]=true;
        board[r][c]='#';
        dfs(r+1,c,board,visited);
        dfs(r-1,c,board,visited);
        dfs(r,c+1,board,visited);
        dfs(r,c-1,board,visited);
    }
}
