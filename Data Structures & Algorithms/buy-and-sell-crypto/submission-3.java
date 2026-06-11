class Solution {
    public int maxProfit(int[] prices) {
        int minBuy=prices[0];
        int maxSell=prices[0];
        int maxProfit=0;
        for(int i=0;i<prices.length;i++)
        {
            if(minBuy>prices[i])
            {
                minBuy=prices[i];
                maxSell=prices[i];
            }
            if(maxSell<prices[i])
            {
                maxSell=prices[i];
                maxProfit=Math.max(maxProfit,maxSell-minBuy);
            }
        }
        return maxProfit;
    }
}
