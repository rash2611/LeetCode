class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<prices.length;i++)
        {
            int profit = 0;
            if(prices[i]<min)
            {
                min = prices[i];
            }
            else
            {
                profit = prices[i] - min;
                if(profit>maxProfit)
                {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
        
    }
}