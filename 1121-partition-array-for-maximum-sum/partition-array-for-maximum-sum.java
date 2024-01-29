class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i = n-1;i>=0;i--)
        {
            int len = 0; 
            int maxElement = Integer.MIN_VALUE;
            int maxi = Integer.MIN_VALUE;
            for(int j = i;j< Math.min(arr.length,i+k);j++)
            {
                len++;
                maxElement = Math.max(maxElement,arr[j]);
                int sum = (len*maxElement) + dp[j+1];
                maxi = Math.max(maxi,sum);
                
            }
            dp[i] = maxi;
        }
        return dp[0];
    }
}