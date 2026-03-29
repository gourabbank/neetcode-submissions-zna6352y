class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> sol=new ArrayList<>();
        backtrack(0,target,nums,new ArrayList<>(),sol);
        return sol;
    }
    public void backtrack(int index, int target, int[] nums, List<Integer> curr, List<List<Integer>> sol)
    {
        if(target<0) return;
        if(target==0)
        {
            sol.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            curr.add(nums[i]);
            backtrack(i,target-nums[i],nums,curr,sol);
            curr.removeLast();
        }
    }
}
