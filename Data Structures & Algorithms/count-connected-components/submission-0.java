class Solution {
    public int countComponents(int n, int[][] edges) {
        int cycles=0;
        boolean visited[]=new boolean[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] e:edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        for(int i=0;i<n;i++)
        {
            if(!visited[i]) 
            {
                dfs(i,graph,visited);
                cycles++;
            }
        }
        return cycles;
    }
    public void dfs(int idx, List<List<Integer>> graph, boolean[] visited)
    {
        if(visited[idx]) return;
        visited[idx]=true;
        for(int next:graph.get(idx))
        {
            dfs(next,graph,visited);
        }
    }
}
