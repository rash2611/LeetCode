class Solution {
    public int findCombinations(int index, int amount,int[] coins, int dp[][])
    {
        if(index == 0)
        {
            if(amount % coins[index] == 0)
                return 1;
            else 
                return 0;
        }
        if(dp[index][amount] != -1)
            return dp[index][amount];
        int notPick = findCombinations(index-1,amount,coins,dp);
        int pick = 0;
        if(coins[index] <= amount)
            pick = findCombinations(index,amount-coins[index], coins,dp);
        return dp[index][amount] = pick + notPick;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return findCombinations(n-1, amount, coins,dp);
    }
}