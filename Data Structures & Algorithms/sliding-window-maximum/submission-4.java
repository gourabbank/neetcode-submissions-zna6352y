class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<>();
        List<Integer> sol=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++)
        {
            dq.offer(nums[i]);
            max=Math.max(nums[i],max);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        sol.add(max);
        for(int i=k;i<nums.length;i++)
        {
            int n=nums[i];
            map.put(n,map.getOrDefault(n,0)+1);
            dq.offer(n);
            int l=dq.pollFirst();
            map.put(l,map.get(l)-1);
            if(l==max && map.get(l)==0)
            {
                max=Integer.MIN_VALUE;
                for(int d:dq)
                {
                    max=Math.max(max,d);
                }
            }
            max=Math.max(n,max);//change
            sol.add(max);
        }
        int[] res=new int[sol.size()];
        for(int i=0;i<sol.size();i++)
        {
            res[i]=sol.get(i);
        }
        return res;
    }
}
