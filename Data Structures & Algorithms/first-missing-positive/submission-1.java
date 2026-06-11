class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums) set.add(n);
        int smallest=1;
        while(set.contains(smallest))
        {
            smallest+=1;
        }
        return smallest;
    }
}