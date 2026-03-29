class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer>[] buckets=new List[nums.length+1];
        for(int n:nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int n:map.keySet())
        {
            int freq=map.get(n);
            if(buckets[freq]==null) buckets[freq]=new ArrayList<>();
            buckets[freq].add(n);
        }
        int sol[] =new int[k];
        int idx=0;
        for(int i=nums.length;i>=0&&idx<k;i--)
        {
            if(buckets[i]==null) continue;
            for(int n:buckets[i])
            {
                sol[idx++]=n;
                if(idx==k) break;
            }
        }
        return sol;
    }
}
