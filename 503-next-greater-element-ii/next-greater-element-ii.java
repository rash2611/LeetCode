class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int ans[] = new int[nums.length];
        for(int i = 0;i<nums.length;i++)
        {
            ans[i] = -1;
            for(int j = i+1; j< i+ nums.length;j++)
            {
                if(nums[j% nums.length] > nums[i])
                {
                    ans[i] = nums[j % nums.length];
                    break;
                }
            }
        }
        return ans;
    }
}