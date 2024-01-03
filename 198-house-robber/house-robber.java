class Solution {
    public int fn(int[] nums, int i, int[] dp){
        if(i < 0)
            return 0;
        if(i == 0)
            return nums[i];
        if(dp[i]!= -1)
            return dp[i];
        return dp[i] = Math.max(nums[i] + fn(nums,i-2,dp), fn(nums,i-1,dp));
    }

    public int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp,-1);
        return fn(nums, nums.length-1, dp);
    }
}