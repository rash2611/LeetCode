class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int front[] = new int[2*k + 1];
        for(int i = 0;i<=2*k;i++)
            front[i] = 0;
        for(int i = n-1;i>=0;i--)
        {
            int curr[] = new int[2*k+1];
            for(int transact = 2*k - 1;transact>=0;transact--)
            {
                if(transact % 2 == 0)
                    curr[transact] = Math.max(-prices[i] + front[transact+1],front[transact]);
        else
            curr[transact] = Math.max(prices[i] + front[transact+1],front[transact]);
            }
            front = curr;
        }
       return front[0];
    }
}