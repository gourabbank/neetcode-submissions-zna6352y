class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(0,nums.length-1,nums);
        return nums;
    }
    public int findPivot(int[] nums, int low, int high)
    {
        return nums[low+(high-low)/2];
    }
    public int partition(int[] nums, int low, int high)
    {
        int pivot=findPivot(nums, low, high);
        int i=low,j=high;
        while(i<=j)
        {
            while(nums[i]<pivot)i++;
            while(nums[j]>pivot)j--;
            if(i<=j)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
        }
        return i;
    }
    public void quickSort(int low, int high, int[] nums)
    {
        if(low>=high) return;
        int splitPoint=partition(nums,low,high);
        quickSort(low,splitPoint-1,nums);
        quickSort(splitPoint,high,nums);
    }
}