class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0], maxProfit = 0;
        for(int i = 1;i<prices.length;i++)
        {
            low = Math.min(low, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - low);
        }
        return maxProfit;
    }
}