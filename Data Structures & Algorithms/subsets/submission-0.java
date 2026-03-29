class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol=new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),sol);
        return sol;
    }
    public void backtrack(int index, int[] nums, List<Integer> curr, List<List<Integer>> sol)
    {
        sol.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++)
        {
            curr.add(nums[i]);
            backtrack(i+1,nums,curr,sol);
            curr.removeLast();
        }
    }
}
