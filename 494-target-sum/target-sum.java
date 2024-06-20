class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totSum = 0;
        for(int i = 0;i<n;i++)
            totSum+=nums[i];
        int sum = (totSum - target)/2;
        if(totSum - target < 0 || (totSum - target) % 2 == 1)
            return 0;
        int prev[] = new int[sum + 1];
        if(nums[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;
        if(nums[0] != 0 && nums[0] <= sum)
            prev[nums[0]] = 1;
        for(int i = 1;i< n;i++)
        {
            int[] curr = new int[sum + 1];
            for(int j = 0;j <= sum;j++)
            {
                int notPick = prev[j];
                int pick = 0;
                if(nums[i] <= j)
                    pick = prev[j - nums[i]];
                curr[j] = pick+notPick;
            }
            prev = curr;
        }
        return prev[sum];
    }
}