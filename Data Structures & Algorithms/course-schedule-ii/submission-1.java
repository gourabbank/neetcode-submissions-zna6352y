class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        for(int[] p:prerequisites)
        {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0) q.offer(i);
        }
        List<Integer> sol=new ArrayList<>();
        while(!q.isEmpty())
        {
            int curr=q.poll();
            sol.add(curr);
            for(int next:graph.get(curr))
            {
                indegree[next]--;
                if(indegree[next]==0) q.offer(next);
            }
        }
        if(sol.size()!=numCourses) return new int[0];
        int result[]=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            result[i]=sol.get(i);
        }
        return result;
    }
}
