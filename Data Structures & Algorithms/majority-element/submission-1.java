class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int val=nums[0];
        for(int n:nums)
        {
            if(n==val)
            {
                cnt++;
            }
            else
            {
                cnt--;
                if(cnt==0)
                {
                    val=n;
                    cnt=1;
                }
            }
        }
        return val;
    }
}