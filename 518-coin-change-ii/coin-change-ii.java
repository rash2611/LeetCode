class Solution {
 
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i = 0;i<= amount;i++)
        {
            if(i % coins[0] == 0)
                dp[0][i] = 1;
            else 
                dp[0][i] = 0;
        }
        for(int index = 1;index<n;index++)
        {
            for(int total = 0;total<=amount; total++)
            {
                int notPick = dp[index-1][total];
                int pick = 0;
                if(coins[index] <= total)
                    pick = dp[index][total-coins[index]];
                dp[index][total] = pick + notPick;
            }
        }
        return dp[n-1][amount];
    }
}