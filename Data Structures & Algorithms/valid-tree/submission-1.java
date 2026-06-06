class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] e:edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        if(isCycle(0,-1,graph,visited)) return false;
        for(boolean b:visited)
        {
            if(!b) return false;
        }
        return true;
    }
    public boolean isCycle(int node, int parent, List<List<Integer>> graph, boolean[] visited)
    {
        if(visited[node])return true;
        visited[node]=true;
        for(int nei:graph.get(node))
        {
            if(nei==parent) continue;
            if(isCycle(nei,node,graph,visited)) return true;
        }
        return false;
    }
}
