class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //Arrays.sort(hand);
        Map<Integer,Integer> map=new HashMap<>();
        for(int h:hand)
        {
            map.put(h,map.getOrDefault(h,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int k:map.keySet())
        {
            pq.offer(k);
        }
        while(!pq.isEmpty())
        {
            int first=pq.peek();
            for(int i=first;i<first+groupSize;i++)
            {
                if(!map.containsKey(i)) return false;
                map.put(i,map.get(i)-1);
                if(map.get(i)==0)
                {
                    pq.poll();
                }
            }
        }
        return true;
    }
}
