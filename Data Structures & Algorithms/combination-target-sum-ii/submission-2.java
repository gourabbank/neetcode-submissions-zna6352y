class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> sol=new ArrayList<>();
        backtrack(0,sol,new ArrayList<>(),candidates,target);
        return sol;
    }
    void backtrack(int idx, List<List<Integer>> sol, List<Integer> curr, int[] candidates, int target)
    {
        if(target==0)
        {
            sol.add(new ArrayList<>(curr));
            return;
        }
        if(target<0) return;
        for(int i=idx;i<candidates.length;i++)
        {
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            curr.add(candidates[i]);
            backtrack(i+1,sol,curr,candidates,target-candidates[i]);
            curr.removeLast();
        }
    }
}
