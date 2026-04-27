class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->
        map.get(b)-map.get(a));
        for(int key:map.keySet())
        {
            pq.offer(key);
        }
        int[] sol=new int[k];
        for(int i=k-1;i>=0;i--)
        {
            sol[i]=pq.poll();
        }
        return sol;
    }
}
