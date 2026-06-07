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
                {    char curr=pq.poll();
                    cycle++;
                    map.put(curr,map.get(curr)-1);
                    if(map.get(curr)>0)
                    {
                        used.add(curr);
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
