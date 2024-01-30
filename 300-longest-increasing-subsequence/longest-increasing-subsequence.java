class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        for(int i = n - 1; i>=0;i--)
        {
            int curr[] = new int[n+1];
            for(int prev = i-1;prev>=-1;prev--)
            {
                int take = Integer.MIN_VALUE;
                int notTake = next[prev+1];
                if(prev == -1 || nums[i] > nums[prev])
                {
                    take = 1 + next[i+1];
                }
                curr[prev+1] = Math.max(notTake,take);
            }
            next = curr;
        }
        return next[0];
    }
}