class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        for(int p[]:prerequisites)
        {
            graph.get(p[0]).add(p[1]);
        }
        int[] visit=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            if(hasCycle(i,graph,visit)) return false;
        }
        
        return true;
        //0-> notvisited 1->visiting 2->completly visited

    }
    public boolean hasCycle(int idx, List<List<Integer>> graph, int[] visit)
    {
        if(visit[idx]==1) return true;
        if(visit[idx]==2) return false;
        visit[idx]=1;
        for(int neighbour:graph.get(idx))
        {
            if(hasCycle(neighbour,graph,visit)) return true;
        }
        visit[idx]=2;
        return false;
    }
}
