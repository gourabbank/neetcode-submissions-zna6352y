class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        for(int[] p:prerequisites)
        {
            graph.get(p[1]).add(p[0]);
        }
        int []visit=new int[numCourses];//0->not visited 1->currently visiting 2->visited
        for(int i=0;i<numCourses;i++)
        {
            if(isCycle(i,graph,visit)) return false;
        }
        return true;
    }
    public boolean isCycle(int idx, List<List<Integer>> graph,int[] visit)
    {
        if(visit[idx]==1) return true;
        visit[idx]=1;
        for(int n:graph.get(idx))
        {
            if(isCycle(n,graph,visit)) return true;
        }
        visit[idx]=2;
        return false;
    }
    
}
