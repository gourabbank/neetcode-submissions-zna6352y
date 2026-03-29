class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int len=1;
        int best=0;
        for(int n:nums)
        {
            set.add(n);
        }
        for(int i=0;i<nums.length;i++)
        {
            int n=nums[i];
            len=1;
            if(!set.contains(n-1))
            {
                while(set.contains(n+1))
                {
                    n=n+1;
                    len++;
                }
            }
            best=Math.max(len,best);
        }
        return best;
    }
}
