class Solution {
    public int f(int[][] dp,int i,int j){
        if(i<0 || j<0)
            return 0;
        if(i == 0 && j == 0)
            dp[i][j] = 1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int left = f(dp,i, j-1);
        int up = f(dp,i-1,j);
        return dp[i][j] = left + up;
    }    
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int row[] : dp)
        {
            Arrays.fill(row,-1);
        }
        return f(dp,m-1,n-1);
    }
}