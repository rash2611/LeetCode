import java.util.*;
class Solution {
    public int f(int[][] grid,int[][] dp, int i, int j)
    {
        if(i == 0 && j == 0)
            return dp[i][j] = grid[i][j];
        if(i == 0)
            return dp[i][j] = f(grid,dp,i,j-1) + grid[i][j];
        if(j == 0)
            return dp[i][j] = f(grid,dp,i-1,j) + grid[i][j];
        if(dp[i][j]!=-1)
            return dp[i][j];            
        int leftPath = f(grid,dp,i,j-1);
        int upPath = f(grid,dp,i-1,j);
        return dp[i][j] = grid[i][j] + Math.min(leftPath,upPath);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else if(i == 0)
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                else if(j == 0)
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                else
                {
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    dp[i][j] = grid[i][j] + Math.min(left,up);
                }
            }
        }
        return dp[m-1][n-1];
    }
}