class Solution {
    public int getMaxCoins(int i,int j,ArrayList<Integer> list, int[][] dp)
    {
        if(i>j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int k = i;k<=j;k++)
        {
            int ans = list.get(i-1) * list.get(k) * list.get(j+1) + getMaxCoins(i,k-1,list,dp) + getMaxCoins(k+1,j,list,dp);
            maxi = Math.max(maxi,ans); 
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int num : nums)
            list.add(num);
        list.add(1);
        int[][] dp = new int[n+1][n+1];
        for(int[] row: dp)
            Arrays.fill(row,-1);
        return getMaxCoins(1,n,list,dp);
    }
}