class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=0;
        int r=k;
        List<Integer> window=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<k;i++) window.add(nums[i]);
        res.add(findMax(window));
        while(r<nums.length)
        {
            window.add(nums[r]);
            window.removeFirst();
            res.add(findMax(window));
            r++;
        }
        int[] sol=new int[res.size()];
        for(int i=0;i<res.size();i++)
        {
            sol[i]=res.get(i);
        }
        return sol;
    }
    public int findMax(List<Integer> list)
    {
        int max=-10001;
        for(int n:list)
        {
            max=Math.max(n,max);
        }
        return max;
    }
}
