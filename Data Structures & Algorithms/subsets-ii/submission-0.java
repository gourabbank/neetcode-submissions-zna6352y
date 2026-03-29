class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(nums);
        //boolean[] visited = new boolean[nums.length];
        backtrack(0,new ArrayList<>(), sol, nums);
        return sol;
    }

    public void backtrack(int idx, List<Integer> curr, List<List<Integer>> sol, int[] nums)
    {
        sol.add(new ArrayList<>(curr));

        for(int i = idx; i < nums.length; i++)
        {
            if(i>idx && nums[i]==nums[i-1]) continue;

            curr.add(nums[i]);
            //visited[i] = true;

            backtrack(i+1,curr, sol, nums);

            curr.remove(curr.size() - 1);
            //visited[i] = false;
        }
    }
}