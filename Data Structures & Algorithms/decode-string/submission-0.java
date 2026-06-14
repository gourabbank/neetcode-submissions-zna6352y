class Solution {
    public String decodeString(String s) {
        Stack<String> st=new Stack<>();
        int l=0,r=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=']')
            {
                st.push(String.valueOf(s.charAt(i)));
            }
            else
            {
                StringBuilder sb=new StringBuilder();
                while(!st.peek().equals("["))
                {
                    sb.insert(0,st.pop());
                }
                st.pop();
                StringBuilder k=new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0)))
                {
                    k.insert(0,st.pop());
                }
                int count=Integer.parseInt(k.toString());
                String repeatedStr=sb.toString().repeat(count);
                st.push(repeatedStr);
            }
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty())
        {
            res.insert(0,st.pop());
        }
        return res.toString();
    }
}