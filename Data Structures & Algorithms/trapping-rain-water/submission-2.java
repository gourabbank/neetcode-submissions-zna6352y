class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int n=height.length;
        int[] lefts=new int[n];
        int[] rights=new int[n];
        lefts[0]=height[0];
        rights[n-1]=height[n-1];
        for(int i=1;i<n;i++)
        {
            lefts[i]=Math.max(lefts[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--)
        {
            rights[i]=Math.max(rights[i+1],height[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=Math.min(lefts[i],rights[i]) - height[i];
        }
        return ans;
    }
}
