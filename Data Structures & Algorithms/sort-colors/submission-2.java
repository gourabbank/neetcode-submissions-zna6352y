class Solution {
    public void sortColors(int[] nums) {
        int z=0,o=0,t=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                nums[t++]=2;
                nums[o++]=1;
                nums[z++]=0;
            }
            else if(nums[i]==1)
            {
                nums[t++]=2;
                nums[o++]=1;
            }
            else
            {
                nums[t++]=2;
            }
        }
    }
}