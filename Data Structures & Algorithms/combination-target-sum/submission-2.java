class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> sol=new ArrayList<>();
        backtrack(0,sol,new ArrayList<>(),nums,target);
        return sol;
    }
    void backtrack(int idx,List<List<Integer>> sol,List<Integer> curr, int[] nums, int target)
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
            backtrack(i,sol,curr,nums,target-nums[i]);
            curr.removeLast();
        }
    }
}
