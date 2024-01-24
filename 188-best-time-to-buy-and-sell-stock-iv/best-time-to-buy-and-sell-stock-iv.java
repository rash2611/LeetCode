class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2*k + 1];
        for(int i = 0;i<=2*k;i++)
            dp[n][i] = 0;
        for(int i = n-1;i>=0;i--)
        {
            for(int transact = 2*k - 1;transact>=0;transact--)
            {
                if(transact % 2 == 0)
                    dp[i][transact] = Math.max(-prices[i] + dp[i+1][transact+1],dp[i+1][transact]);
        else
            dp[i][transact] = Math.max(prices[i] + dp[i+1][transact+1],dp[i+1][transact]);
            }
        }
       return dp[0][0];
    }
}