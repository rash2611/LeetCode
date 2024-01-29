class Solution {
    public boolean isPalindrome(int i, int j, String s)
    {
        while(i<j)
        {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public int getMinCuts(int i, int n, String s,int[] dp)
    {
        if(i == n)
            return 0;
        if(dp[i]!= -1)
            return dp[i];
        int mini = Integer.MAX_VALUE;
        for(int j = i;j<n;j++)
        {
            if(isPalindrome(i,j,s))
            {
                int cost = 1 + getMinCuts(j+1,n,s,dp);
                mini = Math.min(mini,cost);
            }
        }
        return dp[i] = mini;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i : dp)
            Arrays.fill(dp,-1);
        return getMinCuts(0,n,s,dp) - 1;
    }
}