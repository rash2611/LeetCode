class Solution {
    public int getMaxProfit(int i, int transact, int[] prices,int[][] dp)
    {
        if(i == prices.length || transact == 4)
            return 0;
        if(dp[i][transact]!=-1)
            return dp[i][transact];
        if(transact % 2 == 0)
            return dp[i][transact] = Math.max(-prices[i] + getMaxProfit(i+1,transact+1,prices,dp),getMaxProfit(i+1,transact,prices,dp));
        else
            return dp[i][transact] = Math.max(prices[i] + getMaxProfit(i+1,transact+1,prices,dp),getMaxProfit(i+1,transact,prices,dp));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][4];
        for(int row[]: dp)
            Arrays.fill(row,-1);
       return getMaxProfit(0,0,prices,dp); 
    }
}