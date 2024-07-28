class Solution {
    public int findDistinctCount(int ind1, int ind2, String s, String t,int[][] dp)
    {
        if(ind2 < 0)
            return 1;
        if(ind1 < 0)
            return 0;
        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if(s.charAt(ind1) == t.charAt(ind2))
        {
            return dp[ind1][ind2] = findDistinctCount(ind1 - 1, ind2 - 1, s, t,dp) + findDistinctCount(ind1 - 1, ind2, s, t,dp);
        }
        else
        {
            return dp[ind1][ind2] = findDistinctCount(ind1 - 1, ind2, s, t,dp);
        }
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return findDistinctCount(m-1,n-1,s,t,dp);
    }
}