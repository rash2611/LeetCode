class Solution {
    public int atmostSum(int[] nums,int goal)
    {
        int left = 0, right = 0,sum = 0, count = 0;
        while(right < nums.length)
        {
            if(goal<0)
                return 0;
            sum+= nums[right];
            while(sum > goal)
            {
                sum = sum - nums[left];
                left++;
            }
            if(sum <= goal)
                count = count + (right - left + 1);
            right++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = atmostSum(nums,goal) - atmostSum(nums,goal-1);
        return res;
    }
}