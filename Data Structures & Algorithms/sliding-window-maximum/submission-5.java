class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new LinkedList<>(); //index decreasing in value
        int[] res=new int[n-k+1];
        for(int r=0;r<n;r++)
        {
            if(!dq.isEmpty() && dq.peekFirst()<r-k+1) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[r]) dq.pollLast();
            dq.offer(r);
            if(r>=k-1) res[r-k+1]=nums[dq.peekFirst()];
        }
        return res;
    }
}
