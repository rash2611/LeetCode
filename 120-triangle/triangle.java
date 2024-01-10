class Solution {
    public int minimumTotalHelper(List<List<Integer>> triangle, int i, int j, int n, int[][] dp)
    {
        if(i == n-1)
            return dp[i][j] = triangle.get(i).get(j);
        if(dp[i][j]!=-1)
            return dp[i][j];
        int down = minimumTotalHelper(triangle,i+1,j,n,dp);
        int diagonal = minimumTotalHelper(triangle,i+1,j+1,n,dp);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(down,diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return minimumTotalHelper(triangle, 0, 0, n, dp);
    }
}