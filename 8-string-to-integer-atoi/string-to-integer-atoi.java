class Solution {
    public int myAtoi(String s) {
        int i = 0, base = 0, sign = 1;
        if(s.length() == 0)
            return 0;
        //check spaces
        while(i< s.length() && s.charAt(i) == ' ')
            i++;
        if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+'))
        {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        while(i< s.length())
        {
            int digit = s.charAt(i) - '0';
            if(digit < 0 || digit > 9)
                break;
            if(Integer.MAX_VALUE/10 < base || Integer.MAX_VALUE/10 == base && Integer.MAX_VALUE % 10 < digit)
            {
                if(sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            base = 10 * base + digit;
            i++;
        }
        return base * sign;
    }
}