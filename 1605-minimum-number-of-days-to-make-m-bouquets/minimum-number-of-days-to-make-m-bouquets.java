class Solution {
    public boolean createBouquet(int[] bloomDay, int m, int k, int day)
    {
        int count = 0;
        int totBouquet = 0;
        for(int i = 0;i<bloomDay.length;i++)
        {
            if(bloomDay[i] <= day)
                count++;
            else
            {
                totBouquet+= count/k;
                count = 0;
            }
        }
        totBouquet+= count/k;
        return totBouquet >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k > bloomDay.length)
            return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0;i<bloomDay.length;i++)
        {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        while(low<=high)
        {
            int mid = (low + high)/2;
            if(createBouquet(bloomDay,m,k,mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}