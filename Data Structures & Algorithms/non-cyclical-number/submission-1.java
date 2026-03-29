class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(!set.contains(n))
        {
            set.add(n);
            n=help(n);
            if(n==1) return true;
        }
        return false;
    }
    public int help(int n)
    {
        int ans=0;
        while(n!=0)
        {
            int dig=n%10;
            ans+=dig*dig;
            n=n/10;
        }
        return ans;
    }
}
