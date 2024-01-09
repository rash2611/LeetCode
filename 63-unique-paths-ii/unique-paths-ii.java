class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(i == 0 && j == 0 && obstacleGrid[i][j]!=1)
                {
                    dp[i][j] = 1;
                    continue;
                }
                int left = 0, up = 0;
                if(i>0 && obstacleGrid[i][j]!=1)
                    up = dp[i-1][j];
                if(j>0 && obstacleGrid[i][j]!=1)
                    left = dp[i][j-1];
                dp[i][j] = left + up;
            }
        }
        return dp[m-1][n-1];
    }
}