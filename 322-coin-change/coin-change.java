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
        for(int i = 0; i<=amount;i++)
        {
            if(i % coins[0] == 0)
                dp[0][i] = i/coins[0];
            else
                dp[0][i] = (int) Math.pow(10,9);
        }

        for(int i = 1; i<n;i++)
        {
            for(int target = 0; target<=amount;target++)
            {
                int notTake = dp[i-1][target];
                int take = (int) Math.pow(10, 9);
                if(coins[i] <= target)
                    take = 1 + dp[i][target - coins[i]];
                dp[i][target] = Math.min(take,notTake);
            }
        }
        int ans = dp[n-1][amount];
        if(ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}