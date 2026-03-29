class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        Map<Character,Character> map=Map.of(
            ')','(',
            '}','{',
            ']','['
        );
        for(char ch:s.toCharArray())
        {
            if(st.isEmpty() && (ch!=')' || ch!='}' || ch!=']'))
            {
                st.push(ch);
            }
            else
            {
                if(st.peek()==map.get(ch))
                {
                    st.pop();
                }
                else
                {
                    st.push(ch);
                }
            }
        }
        return st.size()==0;
    }
}
