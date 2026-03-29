class Solution {
    Set<Character> set;
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
            if(!horizontalCheck(board,i)) return false;
            if(!verticalCheck(board,i)) return false;
            if(!squareCheck(board,i)) return false;
        }

        return true;
    }
    
    public boolean squareCheck(char[][] board, int n)
    {
        set=new HashSet<>();
        int row=(3*(n%3));
        int col=(3*(n/3));
        for(int i=row;i<row+3;i++)
        {
            for(int j=col;j<col+3;j++)
            {
                char ch=board[i][j];
                if(ch=='.') continue;
                if(set.contains(ch)) return false;
                set.add(ch);
            }
        }
        return true;
    }
    
    public boolean horizontalCheck(char[][] board, int i)
    {
        set=new HashSet<>();
        for(int j=0;j<9;j++)
        {
            char ch=board[i][j];
            if(ch=='.') continue;
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
    public boolean verticalCheck(char[][] board, int j)
    {
        set=new HashSet<>();
        for(int i=0;i<9;i++)
        {
            char ch=board[i][j];
            if(ch=='.') continue;
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
