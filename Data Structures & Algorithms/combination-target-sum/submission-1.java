class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> sol=new ArrayList<>();
        dfs(0,nums,target,sol, new ArrayList<>());
        return sol;
    }
    public void dfs(int idx, int[] nums, int target, List<List<Integer>> sol, List<Integer> curr)
    {
        if(target==0)
        {
            sol.add(new ArrayList<>(curr));
            return;
        }
        if(target<0)
        {
            return;
        }
        for(int i=idx;i<nums.length;i++)
        {
            curr.add(nums[i]);
            dfs(i,nums,target-nums[i],sol,curr);
            curr.removeLast();
        }
    } 
}
