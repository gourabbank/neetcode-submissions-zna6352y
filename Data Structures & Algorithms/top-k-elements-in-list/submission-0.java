class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->map.get(a)-map.get(b)
        );
        for(int n:nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int[] sol=new int[k];
        for(int key:map.keySet())
        {
            pq.add(key);
            if(pq.size()>k) pq.poll();
        }
        for(int i=0;i<k;i++)
        {
            sol[i]=pq.poll();
        }
        return sol;
    }
}
