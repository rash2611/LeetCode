class Solution {
    // 8 7 4 2 2 1 
    //
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int left = 0;
        int right = n-1;
        int maxCoins = 0;
        while(left < right)
        {
            left++;
            maxCoins+= piles[right-1];
            right = right - 2;
        }
        return maxCoins;
    }
}