class Solution {
    public int maxSum(int i,int[] arr,int k,int[] dp)
    {
        if(i == arr.length)
            return 0;
        if(dp[i]!= -1)
            return dp[i];
        int len = 0; 
        int maxElement = Integer.MIN_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int j = i;j< Math.min(arr.length,i+k);j++)
        {
            len++;
            maxElement = Math.max(maxElement,arr[j]);
            int sum = (len*maxElement) + maxSum(j+1,arr,k,dp);
            maxi = Math.max(maxi,sum);
            
        }
        return dp[i] = maxi;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return maxSum(0,arr,k,dp);
    }
}