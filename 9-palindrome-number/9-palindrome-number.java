class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int temp = x;
        while(x>0)
        {
            int tail = x%10;
            rev = rev*10 + tail;
            x = x/10;
        }
        return temp==rev;
    }
}