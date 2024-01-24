class Solution {
    public int maxProfit(int[] prices) {
        int least = prices[0];
        int maxi = 0;
        for(int i = 1; i<prices.length;i++)
        {
            int currPrice = prices[i] - least;
            maxi = Math.max(maxi,currPrice);
            least = Math.min(least,prices[i]);
        }
        return maxi;
    }
}