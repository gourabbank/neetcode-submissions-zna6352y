class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> sol=new ArrayList<>();
        backtrack(0, sol, new ArrayList<>(), nums, new HashSet<>());
        return sol;
    }
    public void backtrack(int idx, List<List<Integer>> sol, List<Integer> curr, int[] nums, Set<Integer> visited)
    {
        if(curr.size()>=nums.length)
        {
            sol.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(visited.contains(nums[i])) continue;
            visited.add(nums[i]);
            curr.add(nums[i]);
            backtrack(i+1, sol, curr, nums, visited);
            curr.removeLast();
            visited.remove(nums[i]);
        }
    }
}
