class Solution {
    public int subarraySum(int[] nums, int k) {
        int currSum=0;
        int sol=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int n:nums)
        {
            currSum+=n;
            int diff=currSum-k;
            if(map.containsKey(diff))
            {
                sol+=map.get(diff);
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return sol;
    }
}