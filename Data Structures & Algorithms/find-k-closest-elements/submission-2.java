class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->
        {
            int distA=Math.abs(a-x);
            int distB=Math.abs(b-x);
            if(distA!=distB) return distB-distA;
            return b-a;
        }
        );
        for(int n:arr)
        {
            pq.offer(n);
            if(pq.size()>k) pq.poll();
        }
        List<Integer> res=new ArrayList<>();
        while(!pq.isEmpty())
        {
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
    }
}