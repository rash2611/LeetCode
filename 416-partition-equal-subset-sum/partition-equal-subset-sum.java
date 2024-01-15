class Solution {
    public boolean isSubsetSum(int[] nums, int i, int target, int[][] dp){
        if(target == 0)
            return true;
        if(i == 0)
            return nums[i] == target;
        if(dp[i][target]!=-1)
            return dp[i][target] == 0 ? false : true;
        boolean notTaken = isSubsetSum(nums, i-1, target, dp);
        boolean taken = false;
        if(nums[i] <= target)
            taken = isSubsetSum(nums, i-1, target - nums[i], dp);
        dp[i][target] = taken || notTaken ? 1 : 0;
        return taken || notTaken;
    }
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        for(int i = 0;i<nums.length;i++)
        {
            totSum+=nums[i];
        }
        if(totSum % 2 != 0)
            return false;
        else
        {
            int k = totSum/2;
            int dp[][] = new int[nums.length][k+1];
            for(int row[] : dp)
                Arrays.fill(row,-1);
            return isSubsetSum(nums,nums.length-1,k, dp);
        }
    }
}