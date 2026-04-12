class Solution {
    public void sortColors(int[] nums) {
        int ones=0, twos=0;
        for(int n:nums)
        {
            if(n==1) ones++;
            else if(n==2) twos++;
        }
        int zeros=nums.length-ones-twos;
        for(int i=0;i<nums.length;i++)
        {
            if(i<zeros) nums[i]=0;
            else if(i<ones+zeros) nums[i]=1;
            else nums[i]=2;
        }
    }
}