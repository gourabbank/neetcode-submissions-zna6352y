class Solution {
    class Trie{
        Trie[] children=new Trie[26];
        boolean isEnd=false;
    }
    Trie root=new Trie();
    int m;
    int n;
    boolean[][] visited;
    boolean found;
    public List<String> findWords(char[][] board, String[] words) {
        m=board.length;
        n=board[0].length;
        visited=new boolean[m][n];
        Trie curr=root;
        List<String> sol=new ArrayList<>();
        for(String s:words)
        {
            found=false;
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    dfs(i,j,board,s,0);
                }
            }
            if(found) sol.add(s);
        }
        return sol;
    }
    public void dfs(int r, int c, char[][] board, String s, int idx)
    {
        if(found) return;
        if(idx==s.length()) 
        {
            found=true;
            return;
        }
        if(r<0 || c<0 || r>=m || c>=n) return;
        if(visited[r][c] || board[r][c]!=s.charAt(idx)) return;
        visited[r][c]=true;
        dfs(r+1,c,board,s,idx+1);
        dfs(r-1,c,board,s,idx+1);
        dfs(r,c+1,board,s,idx+1);
        dfs(r,c-1,board,s,idx+1);
        visited[r][c]=false;
    }
}
