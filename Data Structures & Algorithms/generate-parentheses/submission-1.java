class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        dfs(res,n,0,0,new StringBuilder());
        return res;
    }
    public void dfs(List<String> res, int n, int open, int close, StringBuilder sb)
    {
        if(open==n && close==n)
        {
            res.add(sb.toString());
            return;
        }
        if(open<n)
        {
            sb.append('(');
            dfs(res,n,open+1,close,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open)
        {
            sb.append(')');
            dfs(res,n,open,close+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
