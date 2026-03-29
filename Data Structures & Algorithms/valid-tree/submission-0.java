class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited=new boolean[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] e:edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        if(hasCycle(0,-1,graph,visited)) return false;
        for(boolean v:visited)
        {
            if(!v) return false;
        }
        return true;
    }
    public boolean hasCycle(int idx, int parent, List<List<Integer>> edges, boolean visited[])
    {
        if(visited[idx]) return true;
        visited[idx]=true;
        for(int next:edges.get(idx))
        {
            if(next==parent) continue;
            if(hasCycle(next,idx,edges,visited)) return true;
        }
        return false;
    }
}
