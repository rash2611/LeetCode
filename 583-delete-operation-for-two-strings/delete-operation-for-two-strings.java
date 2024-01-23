class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i = 0;i<m;i++)
        {
            dp[i][0] = 0;
        }
        for(int i = 0;i<n;i++)
        {
            dp[0][i] = 0;
        }
        for(int i = 1;i<=m;i++)
        {
            for(int j = 1;j<=n;j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        int deletion = m - dp[m][n];
        int addition = n - dp[m][n];
        return deletion + addition;
    }
}