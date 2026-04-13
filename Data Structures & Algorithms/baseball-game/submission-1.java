class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(String s:operations)
        {
            if(s.equals("+"))
            {
                int a=st.pop();
                int b=st.pop();
                int res=a+b;
                st.push(b);
                st.push(a);
                st.push(res);
            }
            else if(s.equals("C"))
            {
                st.pop();
            }
            else if(s.equals("D"))
            {
                int a=st.pop();
                st.push(a);
                st.push(2*a);
            }
            else
            {
                st.push(Integer.parseInt(s));
            }
        }
        int ans=0;
        while(!st.isEmpty())
        {
            ans+=st.pop();
        }
        return ans;
    }
}