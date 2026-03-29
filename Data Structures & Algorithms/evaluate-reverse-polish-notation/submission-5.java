class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String s:tokens)
        {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            {
                int a=st.pop();
                int b=st.pop();
                int result=0;
                if(s.equals("+")) result=a+b;
                else if(s.equals("-")) result=b-a;
                else if(s.equals("*")) result=a*b;
                else if(s.equals("/"))result=b/a;    
                st.push(result);            
            }
            else
            {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
