class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> sol=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        backtrack(new ArrayList<>(), sol, nums, 0, visited);
        return sol;
    }
    public void backtrack(List<Integer> curr, List<List<Integer>> sol, int[] nums, int idx, boolean[] visited)
    {
        if(curr.size()==nums.length)
        {
            sol.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(visited[i]) continue;
            curr.add(nums[i]);
            visited[i]=true;
            backtrack(curr, sol, nums, idx+1,visited);
            curr.removeLast();
            visited[i]=false;
        }
    }
}
