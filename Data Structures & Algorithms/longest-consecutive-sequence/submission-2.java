class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums)set.add(n);
        int best=0;
        int len=1;
        for(int i=0;i<nums.length;i++)
        {
            int n=nums[i];
            len=1;
            if(!set.contains(n-1))
            {
                while(set.contains(n+1))
                {
                    len++;
                    n=n+1;
                }
            }
            best=Math.max(best,len);
        }
        return best;
    }
}
