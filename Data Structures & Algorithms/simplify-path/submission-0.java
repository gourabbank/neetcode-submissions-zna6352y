class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        int i=0;
        while(i<path.length())
        {
            while(i<path.length() && path.charAt(i)=='/')
            {
                i++;
            }
            StringBuilder name=new StringBuilder();
            
            while(i<path.length()&&path.charAt(i)!='/')
            {
                name.append(path.charAt(i));
                i++;
            }
            String part=name.toString();
            if(part.equals("") || part.equals("."))
            {
                continue;
            }
            else if(part.equals(".."))
            {
                if(!st.isEmpty())
                {
                    st.pop();
                }
            }
            
            else st.push(part);
        }

        if(st.isEmpty()) return "/";
        
        
        StringBuilder ans = new StringBuilder();

        for (String dir : st) {

            ans.append("/").append(dir);

        }

        return ans.toString();
    }
}