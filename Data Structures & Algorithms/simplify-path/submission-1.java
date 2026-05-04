class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        int i=0;
        String[] parts=path.split("/");
        for(String part:parts)
        {
            if(part.equals("")||part.equals(".")) continue;
            else if(part.equals(".."))
            {
                if(!st.isEmpty()) st.pop();
            }
            else
            {
                st.push(part);
            }
        }
        if(st.isEmpty()) return"/";
        StringBuilder res=new StringBuilder();
        for(String s:st)
        {
            res.append("/").append(s);
        }
        return res.toString();
    }
}