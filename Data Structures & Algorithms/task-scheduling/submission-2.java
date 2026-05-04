class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap<>();
        PriorityQueue<Character> pq=new PriorityQueue<>(
            (a,b)->map.get(b)-map.get(a)
        );
        for(char t:tasks) map.put(t,map.getOrDefault(t,0)+1);
        for(char t:map.keySet()) pq.offer(t);
        int cycleCount=0;
        while(!pq.isEmpty())
        {
            int cycle=0;
            List<Character> used=new ArrayList<>();
            for(int i=0;i<=n;i++)
            {
                if(!pq.isEmpty())
                {
                    char currTask=pq.poll();
                    cycle++;
                    map.put(currTask,map.get(currTask)-1);
                    if(map.get(currTask)>0)
                    {
                        used.add(currTask);
                    }
                }
            }
            for(char t:used)
            {
                pq.offer(t);
            }
            if(pq.isEmpty())
            {
                cycleCount+=cycle;
            }
            else
            {
                cycleCount+=n+1;
            }
        }
        return cycleCount;
    }
}
