class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] arr=path.split("/");
        for(String s:arr)
        {
            if(s.equals(".")||s.equals("")) continue;
            else if(st.isEmpty() && s.equals("..")) continue;
            else if(s.equals("..")) st.pop();
            else st.push(s);
        }
        String ans="";
        if(st.isEmpty()) return "/";
        for(String s:st)
        {
            ans+="/";
            ans+=s;
        }
        return ans;
    }
}