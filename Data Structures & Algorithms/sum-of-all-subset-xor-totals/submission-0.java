class Solution {
    int res=0;
    public int subsetXORSum(int[] nums) {
        backtrack(0,nums,new ArrayList<>());
        return res;
    }
    public void backtrack(int idx, int[] nums, List<Integer> list)
    {
        int xorr=0;
        for(int n:list)
        {
            xorr^=n;
        }
        res+=xorr;
        for(int i=idx;i<nums.length;i++)
        {
            list.add(nums[i]);
            backtrack(i+1,nums,list);
            list.removeLast();
        }
    }
}