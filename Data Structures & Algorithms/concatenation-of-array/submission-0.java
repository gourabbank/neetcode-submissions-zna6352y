class Solution {
    public int[] getConcatenation(int[] nums) {
        int sol[]=new int[2*nums.length];
        for(int i=0;i<2*nums.length;i++)
        {
            if(i>=nums.length) sol[i]=nums[i-nums.length];
            else
            {
                sol[i]=nums[i];
            }
        }
        return sol;
    }
}