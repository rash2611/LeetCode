class Solution {
    public int minBitFlips(int start, int goal) {
        int res = start ^ goal;
        int count = 0;
        while(res > 0)
        {
            if(res % 2 == 1)
                count++;
            res = res/2;
        }
        return count;
    }
}