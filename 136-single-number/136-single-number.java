class Solution {
    public int singleNumber(int[] nums) {
        int xorValue = 0;
        for(int index = 0;index < nums.length; index++)
        {
            xorValue = xorValue ^ nums[index];
        }
        return xorValue;
    }
}