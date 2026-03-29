class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(int i=0;i<s.length();i++)
        {
            if(st.isEmpty())
            {
                st.push(s.charAt(i));
                continue;
            }
            char ch=st.peek();
            if(map.containsKey(ch) && s.charAt(i)==map.get(ch))
            {
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return st.size()==0;
    }
}
