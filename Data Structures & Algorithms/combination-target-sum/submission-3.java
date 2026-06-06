class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> sol=new ArrayList<>();
        backtrack(sol,new ArrayList<>(),0,nums,target);
        return sol;
    }
    public void backtrack(List<List<Integer>> sol, List<Integer> curr, int idx, int[] nums, int target)
    {
        if(target==0)
        {
            sol.add(new ArrayList<>(curr));
            return;
        }
        if(target<0) return;
        for(int i=idx;i<nums.length;i++)
        {
            curr.add(nums[i]);
            backtrack(sol,curr,i,nums,target-nums[i]);
            curr.removeLast();
        }
    }
}
