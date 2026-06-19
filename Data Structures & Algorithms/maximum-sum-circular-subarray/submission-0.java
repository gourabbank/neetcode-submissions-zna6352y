class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=0,maxSum=nums[0],currMax=0;
        int minSum=nums[0],currMin=0;
        for(int n:nums)
        {
            currMax=Math.max(currMax+n,n);
            maxSum=Math.max(maxSum,currMax);
            currMin=Math.min(currMin+n,n);
            minSum=Math.min(currMin,minSum);
            totalSum+=n;
        }
        return maxSum>0?Math.max(maxSum,totalSum-minSum):maxSum;
    }
}