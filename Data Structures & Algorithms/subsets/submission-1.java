class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol=new ArrayList<>();
        //sol.add(new ArrayList<>());
        backtrack(0,nums,sol,new ArrayList<>());
        return sol;
    }
    public void backtrack(int i, int[] nums, List<List<Integer>> sol, List<Integer> list)
    {
        if(i>=nums.length)
        {
            sol.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        backtrack(i+1,nums,sol,list);
        list.remove(list.size()-1);
        backtrack(i+1,nums,sol,list);
    }
}
