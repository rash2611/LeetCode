class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, maxLength = 0, zeros = 0;
        while(right < nums.length)
        {
            if(nums[right] == 0)
                zeros++;
            if(zeros>k)
            {
                if(nums[left] == 0)
                    zeros--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}