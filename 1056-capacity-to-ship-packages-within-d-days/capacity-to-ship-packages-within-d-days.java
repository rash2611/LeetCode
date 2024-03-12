class Solution {
    public int shippingDays(int[] weights, int capacity)
    {
        int load = 0;
        int days = 1;
        for(int i = 0;i<weights.length;i++)
        {
            if(load + weights[i] > capacity)
            {
                days++;
                load = weights[i];
            }
            else
            {
                load+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0; i<weights.length;i++)
        {
            low = Math.max(low,weights[i]);
            high+= weights[i];
        }
        while(low<=high)
        {
            int mid = (low+high)/2;
            int totalDays = shippingDays(weights,mid);
            if( totalDays <= days)
                high = mid - 1; 
            else
                low = mid + 1;
        }
        return low;
    }
}