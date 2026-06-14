class Solution {
    public int mySqrt(int x) {
        int l=0,r=x;
        while(l<=r)
        {
            int ans=l+(r-l)/2;
            if((long) ans*ans==x) return ans;
            else if((long) ans*ans<x) l=ans+1;
            else r=ans-1;
        }
        return l-1;
    }
}