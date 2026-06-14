class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int r=0,l=0;
        for(int w:weights) 
        {
            l=Math.max(l,w);
            r+=w;
        }
        while(l<r)
        {
            int capacity=l+(r-l)/2;
            if(canShip(weights,days,capacity))
            {
                r=capacity;
            }
            else
            {
                l=capacity+1;
            }
        }
        return l;
    }
    public boolean canShip(int[] weights, int days, int capacity)
    {
        int t=1;
        int currWeight=0;
        for(int w:weights)
        {
            if(currWeight+w>capacity) 
            {
                t++;
                currWeight=0;
            }
            currWeight+=w;
        }
        return t<=days;
    }
}