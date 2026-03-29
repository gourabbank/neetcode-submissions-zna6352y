class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high=0;
        for(int p:piles)
        {
            high=Math.max(high,p);
        }
        int minTime=piles.length;
        int low=1,ans=high;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int hours=0;
            for(int p:piles)
            {
                hours+=Math.ceil((double)p/mid);
            }
            if(hours<=h)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}
