class Solution {
    public int longestSubsequenceLength(String text1, String text2, int ind1, int ind2,int[][] dp){
        if(ind1 < 0 || ind2 < 0)
            return 0;
        if(dp[ind1][ind2]!= -1)
            return dp[ind1][ind2];
        if(text1.charAt(ind1) == text2.charAt(ind2))
            return dp[ind1][ind2] = 1 + longestSubsequenceLength(text1,text2,ind1 - 1,ind2 - 1, dp);
        else
            return dp[ind1][ind2] = Math.max(longestSubsequenceLength(text1,text2,ind1,ind2 - 1, dp),longestSubsequenceLength(text1,text2,ind1 - 1, ind2, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return longestSubsequenceLength(text1,text2,m-1,n-1,dp);
    }
}