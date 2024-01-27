import java.util.*;
class Solution {
    public int getMinCost(int i, int j, ArrayList<Integer> c, int[][] dp)
    {
        if(i>j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int ind = i; ind<=j;ind++)
        {
            int ans = c.get(j+1) - c.get(i-1) + getMinCost(i, ind-1,c,dp) + getMinCost(ind + 1,j,c,dp);
            mini = Math.min(mini,ans);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> c = new ArrayList<>();
        for(int cut: cuts)
            c.add(cut);
        c.add(0);
        c.add(n);
        Collections.sort(c);
        int dp[][] = new int[cuts.length+1][cuts.length+1];
        for(int[] row: dp)
            Arrays.fill(row,-1);
        return getMinCost(1,cuts.length,c,dp);

    }
}