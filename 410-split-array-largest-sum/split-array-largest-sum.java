class Solution {
    public int countPartitions(int[] nums, int maxSum)
    {
        int partition = 1;
        int subarraySum = 0;
        for(int i = 0;i<nums.length;i++)
        {
            if(subarraySum + nums[i] <= maxSum)
            {
                subarraySum+=nums[i];
            }
            else
            {
                partition++;
                subarraySum = nums[i];
            }
        }
        return partition;
    }
    public int splitArray(int[] nums, int k) {
        int low = nums[0], high = 0;
        for(int i = 0;i<nums.length;i++)
        {
            low = Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(countPartitions(nums,mid) <= k)
                high = mid - 1;

            else
                low = mid + 1;

        }
        return low;
    }
}