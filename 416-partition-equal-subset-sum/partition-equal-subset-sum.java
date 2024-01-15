class Solution {
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
            boolean prev[] = new boolean[k+1];
            prev[0] = true;
            if(nums[0]<=k)
                prev[nums[0]] = true;
            for(int i = 1;i<n;i++)
            {
                boolean curr[] = new boolean[k+1];
                curr[0] = true;
                for(int target = 1;target<=k;target++)
                {
                    boolean notTaken = prev[target];
                    boolean taken = false;
                    if(nums[i] <= target)
                        taken = prev[target-nums[i]];
                    curr[target] = taken || notTaken;
                }
                prev = curr;
            }
            return prev[k];
       }
    }
}