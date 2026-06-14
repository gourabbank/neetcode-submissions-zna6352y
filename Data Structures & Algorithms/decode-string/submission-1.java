class Solution {
    public String decodeString(String s) {
        Stack<String> stringSt=new Stack<>();
        Stack<Integer> countSt=new Stack<>();
        StringBuilder curr=new StringBuilder();
        int k=0;
        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                k=k*10 + (ch-'0');
            }
            else if(ch=='[')
            {
                stringSt.push(curr.toString());
                countSt.push(k);
                curr=new StringBuilder();
                k=0;
            }
            else if(ch==']')
            {
                String temp=curr.toString();
                curr=new StringBuilder(stringSt.pop());
                int count=countSt.pop();
                for(int i=0;i<count;i++)
                {
                    curr.append(temp);
                }
            }
            else 
            {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}