class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st=new Stack<>(); //index,height
        int maxArea=0;
        for(int i=0;i<heights.length;i++)
        {
            int start=i;
            while(!st.isEmpty() && heights[i]<st.peek()[1])
            {
                int[] top=st.pop();
                int width=i-top[0];
                maxArea=Math.max(maxArea,width*top[1]);
                start=top[0];
            }
            st.push(new int[]{start,heights[i]});
        }
        while(!st.isEmpty())
        {
            int[] top=st.pop();
            int width=heights.length-top[0];
            maxArea=Math.max(maxArea,top[1]*width);
        }
        return maxArea;
    }
}
