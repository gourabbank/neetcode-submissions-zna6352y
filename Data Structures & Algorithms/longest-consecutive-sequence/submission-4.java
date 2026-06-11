class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums)set.add(n);
        int l=0;
        int i=0;
        int maxL=0;
        while(i<nums.length)
        {
            int curr=nums[i];
            l=1;
            if(!set.contains(curr-1))
            {
                while(set.contains(curr+1))
                {
                    l++;
                    curr=curr+1;
                }
            }
            maxL=Math.max(maxL,l);
            i++;
        }
        return maxL;
    }
}
