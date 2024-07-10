class Solution {
    //[1]
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prefixSum = 0;
        int totSum = 0;
        for(int i = 0;i<n;i++)
        {
            totSum+=nums[i];
        }
        for(int i = 0;i<n;i++)
        {
            if(prefixSum == (totSum - prefixSum - nums[i]))
                return i;
            prefixSum+= nums[i];
        }
        return -1;
    }
}