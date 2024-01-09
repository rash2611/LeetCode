class Solution {
    public int f(int dp[][], int[][] obstacleGrid, int i,int j){
        if(i == 0 && j == 0 && obstacleGrid[i][j]!=1)
            return dp[i][j] = 1;
        if(i<0 || j<0 || obstacleGrid[i][j] == 1)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int left = f(dp,obstacleGrid, i, j-1);
        int up = f(dp,obstacleGrid, i-1,j);
        return dp[i][j] = left+up;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int row[] : dp)
            Arrays.fill(row,-1);
        return f(dp,obstacleGrid, m-1,n-1);
    }
}