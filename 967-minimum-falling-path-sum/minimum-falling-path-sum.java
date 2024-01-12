class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        int minSum = Integer.MAX_VALUE;
        for(int i = n-1;i>=0;i--)
        {
            for(int j = n-1;j>=0;j--)
            {
                if(i == n-1)
                {
                    dp[i][j] = matrix[i][j];
                }
                else{
                    int down = dp[i+1][j];
                    int leftDiagonal = Integer.MAX_VALUE;
                    int rightDiagonal = Integer.MAX_VALUE;
                    if(j>0)
                        leftDiagonal = dp[i+1][j-1];
                    if(j<n-1)
                        rightDiagonal = dp[i+1][j+1];
                    dp[i][j] = matrix[i][j] +  Math.min(down, Math.min(leftDiagonal,rightDiagonal));
                    
                }
                if(i == 0)
                        minSum = Math.min(minSum, dp[i][j]);
            }
        }
        return minSum;
    }
}