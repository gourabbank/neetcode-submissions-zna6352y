class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> sol=new HashSet<>();
        Arrays.sort(candidates);
        backtrack(0,target,candidates,new ArrayList<>(),sol);
        return new ArrayList<>(sol);
    }

    public void backtrack(int index, int target, int[] candidates, List<Integer> curr, Set<List<Integer>> sol)
    {
        if(target<0) return;
        if(target==0 && !sol.contains(curr))
        {
            sol.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<candidates.length;i++)
        {
            curr.add(candidates[i]);
            backtrack(i+1,target-candidates[i],candidates,curr,sol);
            curr.removeLast();
        }
    }
}
