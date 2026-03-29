class Solution {
    public boolean canJump(int[] nums) {
        return dfs(0,nums);
    }
    public boolean dfs(int idx, int[] nums)
    {
        if(idx>=nums.length-1) return true;
        for(int jump=1;jump<=nums[idx];jump++)
        {
            if(dfs(idx+jump,nums)) return true;
        }
        return false;
    }
}
