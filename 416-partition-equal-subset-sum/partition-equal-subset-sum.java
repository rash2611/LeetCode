class Solution {
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        for(int i = 0; i < nums.length;i++)
        {
            totSum+=nums[i];
        }
        if(totSum % 2 != 0)
            return false;
        else
        {
            int target = totSum / 2;
            boolean[] prev = new boolean[target+1];
            prev[0] = true;
            if(nums[0] <= target)
                prev[nums[0]] = true;
            for(int i = 1; i<nums.length;i++)
            {
                boolean[] curr = new boolean[target+1];
                for(int k = 1; k<=target;k++)
                {
                    boolean notPick = prev[k];
                    boolean pick = false;
                    if(nums[i] <= k)
                        pick = prev[k - nums[i]];
                    curr[k] = pick || notPick;
                }
                prev = curr;
            }
             return prev[target];
        }
       
    }
}