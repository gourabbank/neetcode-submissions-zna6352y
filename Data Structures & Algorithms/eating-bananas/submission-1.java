class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed=0;
        for(int p:piles)
        {
            maxSpeed=Math.max(maxSpeed,p);
        }
        int l=1,r=maxSpeed;
        int ans=maxSpeed;
        while(l<=r)
        {
            int minSpeed=l+(r-l)/2;
            if(canFinish(piles,minSpeed,h))
            {
                ans=Math.min(ans,minSpeed);
                r=minSpeed-1;
            }
            else
            {
                l=minSpeed+1;
            }
        }
        return ans;
    }
    public boolean canFinish(int[] piles, int s, int hour)
    {
        int h=0;
        for(int p:piles)
        {
            if(p<=s) h++;
            else
            {
                int time= (int) Math.ceil((double) p/s);
                h+=time;
            }
        }
        return h<=hour;
    }
}
