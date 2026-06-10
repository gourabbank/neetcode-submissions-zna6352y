class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int curr=nums[0];
        for(int n:nums)
        {
            if(n==curr)
            {
                cnt++;
                if(cnt>=nums.length/2) return curr;
            }
            else
            {
                cnt--;
                if(cnt==0)
                {
                    curr=n;
                    cnt=1;
                }
            }
        }
        return curr;
    }
}