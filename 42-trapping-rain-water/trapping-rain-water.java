class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int waterTrapped = 0;
        for(int i = 0; i<n;i++)
        {
            int j = i; 
            int leftMax = 0;
            while(j>=0)
            {
                leftMax = Math.max(leftMax, height[j]);
                j--;
            }
            j = i;
            int rightMax = 0;
            while(j<= n-1)
            {
                rightMax = Math.max(rightMax, height[j]);
                j++;
            }
            waterTrapped+= Math.min(leftMax,rightMax) - height[i];
        }
        return waterTrapped;
    }
}