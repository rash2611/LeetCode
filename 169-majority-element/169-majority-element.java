class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorityElement = nums[0];
        for(int i = 0;i<nums.length;i++)
        {
            if(count == 0)
            {
                majorityElement = nums[i];
            }
        if(nums[i]== majorityElement)
            count++;
        else
            count--;
        if(count<0)
        {
            count = 0;
        }
        }
        return majorityElement;
    }
}