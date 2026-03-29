class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int result[]=new int[temperatures.length];
        for(int i=0;i<temperatures.length-1;i++)
        {
            int count=0;
            for(int j=i+1;j<temperatures.length;j++)
            {
                if(temperatures[j]>temperatures[i]) 
                {
                    result[i]=count+1;
                    break;
                }
                count++;
            }
        }
        result[temperatures.length-1]=0;
        return result;
    }
}
