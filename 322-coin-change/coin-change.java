class Solution {
    public int minDenomination(int i, int[] coins,int amount,int[][] dp)
    {
        if(i == 0)
        {
            if(amount % coins[0] == 0)
                return amount/coins[0];
            else
                return (int) Math.pow(10, 9);
        }
        if(dp[i][amount]!= -1)
            return dp[i][amount];
        int notTake = minDenomination(i-1,coins,amount,dp);
        int take = (int) Math.pow(10, 9);
        if(coins[i] <= amount)
            take = 1 + minDenomination(i,coins,amount - coins[i],dp);
        return dp[i][amount] = Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        int ans = minDenomination(n-1,coins,amount,dp);
        if(ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}