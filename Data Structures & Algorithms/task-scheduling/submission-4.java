class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:tasks) map.put(ch,map.getOrDefault(ch,0)+1);
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        int cycleCount=0;
        for(char ch:map.keySet())
        {
            pq.offer(ch);
        }
        while(!pq.isEmpty())
        {
            int cycle=0;
            List<Character> used=new ArrayList<>();
            for(int i=0;i<=n;i++)
            {
                if(!pq.isEmpty())
                {
                    char t=pq.poll();
                    cycle++;
                    map.put(t,map.get(t)-1);
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
            if(!pq.isEmpty())
            {
                cycleCount+=n+1;
            }
            else
            {
                cycleCount+=cycle;
            }
        }
        return cycleCount;
    }
}
