class Solution {
 
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int prev[] = new int[amount+1];
        for(int i = 0;i<= amount;i++)
        {
            if(i % coins[0] == 0)
                prev[i] = 1;
            else 
                prev[i] = 0;
        }
        for(int index = 1;index<n;index++)
        {
            int[] curr = new int[amount+1];
            for(int total = 0;total<=amount; total++)
            {
                int notPick = prev[total];
                int pick = 0;
                if(coins[index] <= total)
                    pick = curr[total-coins[index]];
                curr[total] = pick + notPick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}