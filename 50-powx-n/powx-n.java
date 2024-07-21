class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        long power = Math.abs((long)n);
        while(power > 0)
        {
            if(power % 2 != 0)
            {
                power-= 1;
                res*= x;
            }
            else
            {
                x = x *x;
                power = power/2;
            }
        }
        if(n < 0)
            return 1.0/res;
        else
            return res;
    }
}