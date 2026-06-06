class Solution {
    public int maxProduct(int[] nums) {
        int currMax=1;
        int currMin=1;
        int res=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            int temp=currMax*nums[i];
            currMax=Math.max(nums[i]*currMax,Math.max(nums[i],nums[i]*currMin));
            currMin=Math.min(nums[i],Math.min(temp,nums[i]*currMin));
            res=Math.max(res,currMax);
        }
        return res;
    }
}
