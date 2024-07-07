class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        for(int i = 0;i<n;i++)
        {
            int greatest = -1;
            for(int j = i+1;j<n+i;j++)
            {
                if(nums[j%n] > nums[i])
                {
                    greatest = nums[j%n];
                    break;
                }
            }
            nextGreater[i] = greatest;
        }
        return nextGreater;
    }
}