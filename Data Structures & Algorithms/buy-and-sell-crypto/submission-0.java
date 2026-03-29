class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int minBuy=prices[0];
        for(int p:prices)
        {
            maxProfit=Math.max(maxProfit,p-minBuy);
            minBuy=Math.min(p,minBuy);
        }
        return maxProfit;
    }
}
