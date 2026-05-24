class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int runningSum=0;
        int minLen=nums.length+1;
        for(int right=0;right<nums.length;right++)
        {
            runningSum+=nums[right];
            while(runningSum>=target)
            {
                minLen=Math.min(right-left+1,minLen);
                runningSum-=nums[left];
                left++;
                //right=left;
            }
        }
        return minLen==nums.length+1?0:minLen;
    }
}