class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int prev[] = new int[n];
        for(int i = 0;i<m;i++)
        {
            int temp[] = new int[n];
            for(int j = 0;j<n;j++)
            {
                if(i == 0 && j == 0 && obstacleGrid[i][j]!=1)
                {
                    temp[j] = 1;
                    continue;
                }
                int left = 0, up = 0;
                if(i>0 && obstacleGrid[i][j]!=1)
                    up = prev[j];
                if(j>0 && obstacleGrid[i][j]!=1)
                    left = temp[j-1];
                temp[j] = left + up;
            }
            prev = temp;
        }
        return prev[n-1];
    }
}