class Solution {
    public int missingNumber(int[] nums) {
        int xorValue = nums.length;
        for(int index = 0; index<nums.length;index++)
        {
            xorValue = xorValue ^ nums[index] ^ index;
        }
        
        return xorValue;
    }
}