class Solution {
    int res=0;
    public int subsetXORSum(int[] nums) {
        backtrack(0,nums, new ArrayList<>());
        return res;
    }
    public void backtrack(int idx, int[] nums, List<Integer> list)
    {
        int sum=0;
        for(int n:list)
        {
            sum^=n;
        }
        res+=sum;
        for(int i=idx;i<nums.length;i++)
        {
            list.add(nums[i]);
            backtrack(i+1,nums,list);
            list.remove(list.size()-1);
        }
    }
}