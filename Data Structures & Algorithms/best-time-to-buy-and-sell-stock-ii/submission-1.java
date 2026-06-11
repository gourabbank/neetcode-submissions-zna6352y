class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int sell=0;
        int p=0;
        for(int i=1;i<prices.length;i++)
        {
            if(buy>prices[i])
            {
                buy=prices[i];
                sell=prices[i];
            }
            if(prices[i]>sell)
            {
                sell=prices[i];
                p+=sell-buy;
                sell=prices[i];
                buy=prices[i];
            }
        }
        return p;
    }
}