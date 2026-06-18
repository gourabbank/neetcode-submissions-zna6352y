class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> r=new LinkedList<>();
        Deque<Integer> d=new LinkedList<>();
        int n=senate.length();
        for(int i=0;i<n;i++)
        {
            if(senate.charAt(i)=='R') r.offer(i);
            else d.offer(i);
        }
        while(!r.isEmpty() && !d.isEmpty())
        {
            int rLoc=r.poll();
            int dLoc=d.poll();
            if(rLoc<dLoc)
            {
                r.offer(rLoc+n);
            }
            else
            {
                d.offer(dLoc+n);
            }
        }
        return r.isEmpty()?"Dire":"Radiant";
    }
}