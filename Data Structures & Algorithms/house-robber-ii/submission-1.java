class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int dp_first[]=new int[n];
        int dp_last[]=new int[n];
        dp_first[0]=nums[0];
        dp_last[0]=nums[1];
        dp_first[1]=Math.max(nums[0],nums[1]);
        dp_last[1]=Math.max(nums[2],nums[1]);
        for(int i=2;i<n-1;i++)
        {
            dp_first[i]=Math.max(dp_first[i-1],nums[i]+dp_first[i-2]);
            dp_last[i]=Math.max(dp_last[i-1],nums[i+1]+dp_last[i-2]);
        }
        return Math.max(dp_first[n-2],dp_last[n-2]);
    }
}
