class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int zeroes = 0;
        while(index<nums.length)
        {
            if(nums[index]==0)
            {
                index++;
            }
            else
            {
                int temp = nums[index];
                nums[index] = nums[zeroes];
                nums[zeroes] = temp;
                index++;
                zeroes++;
            }
        }
        
    }
}