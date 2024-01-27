class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int num : nums)
            list.add(num);
        list.add(1);
        int[][] dp = new int[n+2][n+2];
        for(int i = n;i>=1;i--)
        {
            for(int j = 1;j<=n;j++)
            {
                if(i>j)
                    continue;
                int maxi = Integer.MIN_VALUE;
                for(int k = i;k<=j;k++)
                {
                    int ans = list.get(i-1) * list.get(k) * list.get(j+1) + dp[i][k-1] + dp[k+1][j];
                    maxi = Math.max(maxi,ans);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
}