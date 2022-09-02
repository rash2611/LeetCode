class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int countOnes = 0;
        for(int index = 0;index<nums.length;index++)
        {
            if(nums[index] == 1)
            {
                countOnes++;
                maxOnes = Math.max(countOnes,maxOnes);
            }
            else
            {
                
                countOnes = 0;
            }
        }
        return maxOnes;
    }
}