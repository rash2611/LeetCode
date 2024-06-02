class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int maxi[] = new int[n];
        maxi[0] = 1;
        int count = 0;
        for(int i = 1;i<n;i++)
        {
            if(ratings[i] > ratings[i-1])
                maxi[i] = maxi[i-1] + 1;
            else
                maxi[i] = 1;
        }
        maxi[n - 1] = Math.max(maxi[n-1], 1);
        count+=maxi[n-1];
        for(int i = n-2;i>=0;i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                maxi[i] = Math.max(maxi[i], maxi[i+1] + 1);
                count+=maxi[i];
            }
            else
            {
                maxi[i] = Math.max(maxi[i], 1);
                count+=maxi[i];
            }
        }
        return count;
    }
}