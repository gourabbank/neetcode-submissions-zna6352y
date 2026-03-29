class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int l=temperatures.length;
        Stack<Integer> st=new Stack<>();
        int sol[]=new int[l];
        for(int i=l-1;i>=0;i--)
        {
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i])
            {
                st.pop();
            }
            sol[i]=st.isEmpty()?0:st.peek()-i;
            st.push(i);
        }
        return sol;
    }
}
