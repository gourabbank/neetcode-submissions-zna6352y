class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        Stack<Integer> st=new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i])
            {
                st.pop();
            }
            res[i]=st.isEmpty()?0:st.peek()-i;
            st.push(i);
        }
        return res;
    }
}
