class Solution {
    class Trie{
        Trie[] children=new Trie[26];
        String word=null;
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
        Trie root = new Trie();
        for (String w : words) {
            Trie curr = root;
            for (char ch : w.toCharArray()) {
                int idx = ch - 'a';
                if (curr.children[idx] == null) curr.children[idx] = new Trie();
                curr = curr.children[idx];
            }
            curr.word = w;
        }
        List<String> sol=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dfs(board,i,j,root,sol);
            }
        }
        return sol;
    }
    public void dfs(char[][] board,int r, int c, Trie root, List<String> sol)
    {
        if(r<0 || c<0 || r>=m || c>=n) return;
        char ch=board[r][c];
        if(visited[r][c] || root.children[ch-'a']==null) return;
        root=root.children[ch-'a'];
        if(root.word!=null)
        {
            sol.add(root.word);
            root.word=null;
        }
        visited[r][c]=true;
        dfs(board,r+1,c,root,sol);
        dfs(board,r-1,c,root,sol);
        dfs(board,r,c+1,root,sol);
        dfs(board,r,c-1,root,sol);
        visited[r][c]=false;
    }
}
