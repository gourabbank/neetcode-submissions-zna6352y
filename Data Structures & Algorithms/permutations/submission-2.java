class Solution {
    List<List<Integer>> sol=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,0);
        return sol;
    }
    public void backtrack(int[] nums, int idx)
    {
        if(idx==nums.length)
        {
            List<Integer> perm=new ArrayList<>();
            for(int n:nums) perm.add(n);
            sol.add(perm);
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            swap(nums,idx,i);
            backtrack(nums, idx+1);
            swap(nums,idx,i);
        }
    }
    public void swap(int[] nums, int i, int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
