class Solution {
    public int maxArea(int[] heights) {
        int l=0,r=heights.length-1;
        int max=0;
        int height=0;
        while(l<r)
        {
            height=Math.min(heights[l],heights[r]);
            int area=(r-l)*(height);
            max=Math.max(max,area);
            if(heights[l]<heights[r]) l++;
            else r--;
        }
        return max;
    }
}
