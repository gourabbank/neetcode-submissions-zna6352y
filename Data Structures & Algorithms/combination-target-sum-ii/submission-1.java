class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> sol=new ArrayList<>();
        dfs(0,candidates, target, sol, new ArrayList<>());
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
            if(i>idx && nums[i-1]==nums[i]) continue;
            curr.add(nums[i]);
            dfs(i+1,nums,target-nums[i],sol,curr);
            curr.removeLast();
        }
    }
}
