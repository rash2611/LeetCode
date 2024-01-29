class Solution {
    public int findLIS(int i, int prev, int[] nums, int[][] dp)
    {
        if(i == nums.length)
            return 0;
        if(dp[i][prev+1]!= -1)
            return dp[i][prev+1];
        int take = Integer.MIN_VALUE;
        int notTake = findLIS(i+1,prev,nums,dp);
        if(prev == -1 || nums[i] > nums[prev])
        {
            take = 1 + findLIS(i+1,i,nums,dp);
        }
        return dp[i][prev+1] = Math.max(take,notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return findLIS(0,-1,nums,dp);
    }
}