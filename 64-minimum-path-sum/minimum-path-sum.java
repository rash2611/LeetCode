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
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return f(grid,dp,m-1,n-1);
    }
}