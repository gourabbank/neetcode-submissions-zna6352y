class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int area=0;
        int minHeight=0;
        while(left<right)
        {
            minHeight=Math.min(heights[left],heights[right]);
            area=Math.max((right-left)*minHeight,area);
            if(heights[left]<heights[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return area;
    }
}
