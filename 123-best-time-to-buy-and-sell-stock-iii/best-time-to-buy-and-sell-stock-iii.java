class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][5];
        for(int i = 0;i<=4;i++)
            dp[n][i] = 0;
        for(int i = n-1;i>=0;i--)
        {
            for(int transact = 3;transact>=0;transact--)
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