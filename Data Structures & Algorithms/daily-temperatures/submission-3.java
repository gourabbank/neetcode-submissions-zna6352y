class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int sol[]=new int[n];
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(temperatures[j]>temperatures[i])
                {
                    sol[i]=j-i;
                    break;
                }
            }
        }
        return sol;
    }
}
