class Solution {
    public int countOperations(String word1, String word2, int index1, int index2,int[][] dp)
    {
        if(index1 < 0)
            return 1 + index2;
        if(index2 < 0)
            return 1 + index1;
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        if(word1.charAt(index1) == word2.charAt(index2))
            return dp[index1][index2] = countOperations(word1,word2,index1 - 1, index2 - 1,dp);
        else
        {
            int insertionCount = 1 + countOperations(word1,word2,index1,index2 - 1,dp);
            int deletionCount = 1 + countOperations(word1, word2, index1 - 1, index2,dp);
            int replaceCount = 1 + countOperations(word1, word2, index1 - 1, index2 - 1,dp);
            return dp[index1][index2] = Math.min(insertionCount, Math.min(deletionCount, replaceCount));
        }
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return countOperations(word1,word2, m-1, n-1,dp);
    }
}