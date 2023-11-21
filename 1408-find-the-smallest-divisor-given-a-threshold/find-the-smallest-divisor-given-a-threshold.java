class Solution {
    public int findMax(int[] nums)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++)
        {
           max = Math.max(max,nums[i]); 
        }
        return max;
    }
    public int divisorSum(int[] nums, int divisor)
    {
        int sum = 0;
        for(int i = 0;i<nums.length;i++)
        {
            sum+= Math.ceil(nums[i]/(double)divisor);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = findMax(nums);
        while(low<=high)
        {
            int mid = (low+high)/2;
            int sum = divisorSum(nums,mid);
            if(sum<=threshold)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}