class Solution {
    public int atmostK(int[] nums, int k)
    {
        int left = 0, right = 0, count = 0, sum = 0;
        while(right < nums.length)
        {
            if(k <0)
                return 0;
            sum+= nums[right] %2;
            while(sum > k)
            {
                sum-= nums[left] % 2;
                left++;
            }
            if(sum <= k)
            {
                count = count + (right - left + 1);
            }
            right++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int res = atmostK(nums,k) - atmostK(nums, k-1);
        return res;
    }
}