import java.util.*;
class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> c = new ArrayList<>();
        for(int cut: cuts)
            c.add(cut);
        c.add(0);
        c.add(n);
        Collections.sort(c);
        int dp[][] = new int[cuts.length+2][cuts.length+2];
        for(int i = cuts.length; i>=1;i--)
        {
            for(int j = 1;j<= cuts.length;j++)
            {
                if(i>j)
                    continue;
                int mini = Integer.MAX_VALUE;
                for(int k = i;k<=j;k++)
                {
                    int ans = c.get(j+1) - c.get(i-1) + dp[i][k-1] + dp[k+1][j];
                    mini = Math.min(mini,ans);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][cuts.length];

    }
}