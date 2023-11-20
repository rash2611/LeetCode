class Solution {
    public int findMax(int[] piles)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<piles.length;i++)
        {
            max = Math.max(max,piles[i]);
        }
        return max;
    }
    public int calcHours(int[] piles, int hours)
    {
        int totalHours = 0;
        for(int i = 0;i<piles.length;i++)
        {
            totalHours+= Math.ceil(piles[i]/(double)hours);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        while(low<=high)
        {
            int mid = (low + high)/2;
            int reqHours = calcHours(piles,mid);
            if(reqHours<=h)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
}