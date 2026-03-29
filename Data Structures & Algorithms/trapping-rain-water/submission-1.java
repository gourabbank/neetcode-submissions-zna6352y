class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int leftHeight=0,rightHeight=0;
        int h=0;
        int ans=0;
        for(int i=0;i<height.length;i++)
        {
            leftHeight=Math.max(leftHeight,height[i]);
            rightHeight=0;
            for(int j=i;j<height.length;j++)
            {
                rightHeight=Math.max(rightHeight,height[j]);
            }
            h=Math.min(leftHeight,rightHeight);
            int water=h-height[i];
            ans+=water;
        }
        return ans;
    }
}
