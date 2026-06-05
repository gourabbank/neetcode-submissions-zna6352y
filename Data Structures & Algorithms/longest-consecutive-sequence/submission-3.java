class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int currStreak=0;
        int longestStreak=0;
        for(int n:nums)set.add(n);
        int i=0;
        while(i<nums.length)
        {
            int n=nums[i];
            currStreak=1;
            if(!set.contains(n-1))
            {
                while(set.contains(n+1))
                {
                    currStreak++;
                    n++;
                }
                
            }
            longestStreak=Math.max(longestStreak,currStreak);
            i++;
        }
        return longestStreak;
    }
}
