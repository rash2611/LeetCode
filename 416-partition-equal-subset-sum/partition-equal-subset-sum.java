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
        int n = nums.length;
        for(int i = 0;i<n;i++)
        {
            totSum+=nums[i];
        }
        if(totSum % 2 != 0)
            return false;
        else
        {
            int k = totSum/2;
            boolean dp[][] = new boolean[n][k+1];
            for(int i = 0;i<n;i++)
            {
                dp[i][0] = true;
            }
            if(nums[0]<=k)
                dp[0][nums[0]] = true;
            for(int i = 1;i<n;i++)
            {
                for(int target = 1;target<=k;target++)
                {
                    boolean notTaken = dp[i-1][target];
                    boolean taken = false;
                    if(nums[i] <= target)
                        taken = dp[i-1][target-nums[i]];
                    dp[i][target] = taken || notTaken;
                }
            }
            return dp[n-1][k];
       }
    }
}