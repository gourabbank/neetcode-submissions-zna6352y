class Solution {
    char[][] board;
    public boolean isValidSudoku(char[][] board) {
        this.board=board;
        for(int i=0;i<9;i++)
        {
            if(!rowCheck(i)) return false;
            if(!colCheck(i)) return false;
            if(!gridCheck(i)) return false;
        }
        return true;
    }
    public boolean rowCheck(int r)
    {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<9;i++)
        {
            if(board[r][i]=='.') continue;
            int dig=board[r][i]-'0';
            if(set.contains(dig)) return false;
            set.add(dig);
        }
        return true;
    }
    public boolean colCheck(int c)
    {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<9;i++)
        {
            if(board[i][c]=='.') continue;
            int dig=board[i][c]-'0';
            if(set.contains(dig)) return false;
            set.add(dig);
        }
        return true;
    }
    public boolean gridCheck(int g)
    {
        Set<Integer> set=new HashSet<>();
        int col=3*(g/3);
        int row=3*(g%3);
        for(int i=row;i<row+3;i++)
        {
            for(int j=col;j<col+3;j++)
            {
                if(board[i][j]=='.')continue;
                int dig=board[i][j]-'0';
                if(set.contains(dig)) return false;
                set.add(dig);
            }
        }
        return true;
    }
}
