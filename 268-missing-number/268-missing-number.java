class Solution {
    public int missingNumber(int[] nums) {
        int xorValue = 0;
        for(int index = 0; index<nums.length;index++)
        {
            xorValue = xorValue ^ nums[index] ^ index;
        }
        // for(int i = 0;i<=nums.length;i++)
        // {
        //     xorValue = xorValue^i;
        // }
        
        return xorValue^nums.length;
    }
}