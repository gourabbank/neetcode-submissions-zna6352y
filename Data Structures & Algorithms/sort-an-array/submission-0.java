class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
    public void quicksort(int[] nums, int left, int right)
    {
        if(left>=right) return;
        int pivotIndex=partition(nums,left,right);
        quicksort(nums,left,pivotIndex-1);
        quicksort(nums,pivotIndex+1,right);
    }
    public int partition(int[] nums, int left, int right)
    {
        int pivot=nums[right];
        int i=left-1;
        for(int j=left;j<right;j++)
        {
            if(nums[j]<=pivot)
            {
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,right);
        return i+1;
    }
    private void swap(int[] nums, int i, int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}