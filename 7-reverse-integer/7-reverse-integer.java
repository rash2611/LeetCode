class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x!=0)
        {
            int digit = x%10;
            int newrev = rev *10 + digit;
            if((newrev-digit)/10 != rev)
                return 0;
            rev = newrev;
            x = x/10;
        }
        return rev;
    }
}