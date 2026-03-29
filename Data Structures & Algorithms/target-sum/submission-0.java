class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(0,0,nums,target);
    }
    public int backtrack(int idx, int sum, int[] nums, int target)
    {
        if(idx==nums.length)
        {
            return (sum==target?1:0);
        }
        return backtrack(idx+1,sum+nums[idx],nums,target)+backtrack(idx+1,sum-nums[idx],nums,target);
    }
}
