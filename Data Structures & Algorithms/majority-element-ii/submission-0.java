class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> sol=new ArrayList<>();
        int majority=nums.length/3;
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int k:map.keySet())
        {
            int v=map.get(k);
            if(v>majority)
            {
                sol.add(k);
            }
        }
        return sol;
    }
}