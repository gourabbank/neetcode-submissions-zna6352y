class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        for(int[] p:prerequisites)
        {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        List<Integer> sol=new ArrayList<>();
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int currCourse=q.poll();
                if(indegree[currCourse]==0)
                {
                    sol.add(currCourse);
                }
                for(int n:graph.get(currCourse))
                {
                    indegree[n]--;
                    if(indegree[n]==0)
                    {
                        q.offer(n);
                    }
                }
            }
        }
        if(sol.size()!=numCourses) return new int[0];
        int result[] =new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            result[i]=sol.get(i);
        }
        return result;
    }
}
