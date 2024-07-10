class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right)
        {
            int minHeight = 0;
            if(height[left] <= height[right])
            {
                minHeight = height[left];
                left++;
            }
            else
            {
                minHeight = height[right];
                right--;
            }
            maxArea = Math.max(maxArea, minHeight * (right - left + 1));
        }
        return maxArea;
    }
}