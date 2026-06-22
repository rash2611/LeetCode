class Solution {
    public int maxProfit(int[] prices) {
        int least = prices[0];
        int max = 0;
        for(int i = 0; i<prices.length;i++)
        {
            if(prices[i]<least)
                least = prices[i];
            if(max<(prices[i] - least))
                max = prices[i] - least;
        }
        return max;
    }
}