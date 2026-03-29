class Solution {

    boolean found;

    public List<String> findWords(char[][] board, String[] words) {
        List<String> sol = new ArrayList<>();
        int rows = board.length, cols = board[0].length;

        for (String s : words) {
            found = false;

            for (int i = 0; i < rows && !found; i++) {
                for (int j = 0; j < cols && !found; j++) {
                    dfs(board, i, j, s, 0);
                }
            }

            if (found) sol.add(s);
        }

        return sol;
    }

    public void dfs(char[][] board, int r, int c, String s, int idx) {
        if (found) return; // stop if already found
        if (idx == s.length()) { 
            found = true; 
            return;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;

        char ch = board[r][c];
        if (ch == '#' || ch != s.charAt(idx)) return;

        board[r][c] = '#';

        dfs(board, r + 1, c, s, idx + 1);
        dfs(board, r - 1, c, s, idx + 1);
        dfs(board, r, c + 1, s, idx + 1);
        dfs(board, r, c - 1, s, idx + 1);

        board[r][c] = ch; // restore
    }
}