class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int buy=prices[0];
        for(int p:prices)
        {
            maxProfit=Math.max((p-buy),maxProfit);
            buy=Math.min(p,buy);
        }
        return maxProfit;
    }
}
