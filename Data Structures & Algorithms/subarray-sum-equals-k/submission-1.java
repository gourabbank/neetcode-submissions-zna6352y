class Solution {
    public int subarraySum(int[] nums, int k) {
        int res=0,currSum=0;
        Map<Integer,Integer> prefixSum=new HashMap<>();
        prefixSum.put(0,1);
        for(int n:nums)
        {
            currSum+=n;
            int diff=currSum-k;
            res+=prefixSum.getOrDefault(diff,0);
            prefixSum.put(currSum,prefixSum.getOrDefault(currSum,0)+1);
        }
        return res;
    }
}