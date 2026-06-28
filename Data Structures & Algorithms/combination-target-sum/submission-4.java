class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> sol=new ArrayList<>();
        backtrack(0,nums,sol,new ArrayList<>(),target);
        return sol;
    }
    public void backtrack(int idx, int[] nums, List<List<Integer>> sol, List<Integer> curr, int target)
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
            backtrack(i,nums,sol,curr,target-nums[i]);
            curr.remove(curr.size()-1);
        }
    }
}
