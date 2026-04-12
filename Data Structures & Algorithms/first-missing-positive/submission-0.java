class Solution {
    public int firstMissingPositive(int[] nums) {
        int l=nums.length;
        boolean[] seen=new boolean[l];
        for(int n:nums)
        {
            if(n>0 && n<=l)
            {
                seen[n-1]=true;
            }
        }
        for(int i=0;i<l;i++)
        {
            if(!seen[i]) return i+1;
        }
        return l+1;
    }

}