class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++)graph.add(new ArrayList<>());
        int[] indegree=new int[numCourses];
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
        if(q.isEmpty()) return new int[0];
        List<Integer> res=new ArrayList<>();
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int currCourse=q.poll();
                if(indegree[currCourse]==0)
                {
                    res.add(currCourse);
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
        if(res.size()!=numCourses) return new int[0];
        int[] sol=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            sol[i]=res.get(i);
        }
        return sol;
    }
}
