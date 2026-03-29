class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap<>();
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(char t:tasks)
        {
            map.put(t,map.getOrDefault(t,0)+1);
        }
        for(char t:map.keySet())
        {
            pq.offer(t);
        }
        int cycleCount=0;
        while(!pq.isEmpty())
        {
            List<Character> used=new ArrayList<>();
            int work=0;
            for(int i=0;i<=n;i++)
            {
                if(!pq.isEmpty())
                {
                    char t=pq.poll();
                    work++;
                    int freq=map.get(t);
                    map.put(t,freq-1);
                    if(map.get(t)>0)
                    {
                        used.add(t);
                    }
                }
            }
            for(char t:used)
            {
                pq.offer(t);
            }
            if(pq.isEmpty())
            {
                cycleCount+=work;
            }
            else
            {
                cycleCount+=n+1;
            }
        }
        return cycleCount;
    }
}
