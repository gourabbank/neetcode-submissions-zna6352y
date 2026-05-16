class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> sol=new ArrayList<>();
        backtrack(1,sol,new ArrayList<>(),n,k);
        return sol;
    }
    void backtrack(int idx, List<List<Integer>> sol, List<Integer> curr, int n, int k)
    {
        if(curr.size()==k)
        {
            sol.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<=n;i++)
        {
            curr.add(i);
            backtrack(i+1,sol,curr,n,k);
            curr.removeLast();
        }
    }
}