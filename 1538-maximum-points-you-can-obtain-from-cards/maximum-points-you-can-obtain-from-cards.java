class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        int maxSum = 0;
        for(int i = 0; i<k; i++)
        {
            total+= cardPoints[i];
        }
        maxSum = total;
        for(int i = 0; i<k;i++)
        {
            total-= cardPoints[k-1-i];
            total+= cardPoints[n-1-i];
            maxSum = Math.max(maxSum, total);
        }
        return maxSum;
    }
}