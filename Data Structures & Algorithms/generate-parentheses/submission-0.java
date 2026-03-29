class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> sol=new ArrayList<>();
        backtrack(0,0,sol,n,new StringBuilder());
        return sol;
    }
    public void backtrack(int open, int close, List<String> sol, int n, StringBuilder sb)
    {
        if(open==n && close==n)
        {
            sol.add(sb.toString());
            return;
        }
        if(open<n)
        {
            sb.append('(');
            backtrack(open+1,close,sol,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open)
        {
            sb.append(')');
            backtrack(open,close+1,sol,n,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
