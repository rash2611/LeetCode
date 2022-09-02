class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int countOnes = 0;
        for(int index = 0;index<nums.length;index++)
        {
            if(nums[index] == 1)
            {
                countOnes++;
            }
            else
            {
                if(countOnes>maxOnes)
                {
                    maxOnes = countOnes;
                }
                countOnes = 0;
            }
        }
         if(countOnes>maxOnes)
        {
            maxOnes = countOnes;
        }
        return maxOnes;
    }
}