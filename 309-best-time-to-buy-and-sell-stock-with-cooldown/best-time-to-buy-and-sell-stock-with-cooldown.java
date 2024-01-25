class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] front1 = new int[2];
        int[] front2 = new int[2];
        for(int i = n-1; i>=0;i--)
        {
            int[] curr = new int[2];
            for(int buy = 0;buy<2;buy++)
            {
                if(buy == 1)
                    curr[buy] = Math.max(-prices[i] + front1[0], front1[1]);
                else
                    curr[buy] = Math.max(prices[i] + front2[1], front1[0]);
            }
            front2 = front1;
            front1 = curr;

        }
        return front1[1];
    }
}