class Solution {
    public int mySqrt(int x) {
        if(x>=2147395600) return 46340;
        if(x==0) return 0;
        if(x==1) return 1;
        for(int i=2;i<x;i++)
        {
            if(i*i==x) return i;
            if(i*i>x)
            {
                if((i-1)*(i-1) <x) return i-1;
            }
        }
        return 0;
    }
}