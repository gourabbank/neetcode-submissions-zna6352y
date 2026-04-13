class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n<3) return 1;
        int curr=0;
        int a=0,b=1,c=1;
        for(int i=2;i<n;i++)
        {
            curr=a+b+c;
            a=b;
            b=c;
            c=curr;
        }
        return curr;
    }
}