class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int k=0,i=0;
        while(i<nums.length)
        {
            if(nums[i]!=val)
            {
                nums[k++]=nums[i];
            }
            i++;
        }
        return k;
    }
}