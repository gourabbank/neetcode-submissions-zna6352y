class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int maxSum=nums[0];
        for(int r=0;r<nums.length;r++)
        {
            if(sum<0)
            {
                sum=0;
            }
            sum+=nums[r];
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
}
