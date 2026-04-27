class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice=prices[0];
        int maxProfit=0;
        for(int p:prices)
        {
            int profit=p-buyPrice;
            maxProfit=Math.max(profit,maxProfit);
            buyPrice=Math.min(p,buyPrice);
        }
        return maxProfit;
    }
}
