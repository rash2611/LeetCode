class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int front[] = new int[2];
        for(int i = n-1;i>=0;i--)
        {
            int curr[] = new int[2];
            for(int buy = 0; buy<2;buy++)
            {
                if(buy == 1)
                    curr[buy] = Math.max(-prices[i] + front[0], front[1]);
                else
                    curr[buy] = Math.max(prices[i] - fee + front[1],front[0]);
            }
            front = curr;
        }
        return front[1];
    }
}