class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer>[] buckets=new List[nums.length+1];
        for(int key:map.keySet())
        {
            int freq=map.get(key);
            if(buckets[freq]==null) buckets[freq]=new ArrayList<>();
            buckets[freq].add(key);
        }
        int[] sol=new int[k];
        int idx=0;
        for(int f=buckets.length-1; f>=0 && idx<k;f--)
        {
            if(buckets[f]==null) continue;
            for(int n:buckets[f])
            {
                sol[idx++]=n;
                if(idx==k) break;
            }
        }
        return sol;
    }
}
