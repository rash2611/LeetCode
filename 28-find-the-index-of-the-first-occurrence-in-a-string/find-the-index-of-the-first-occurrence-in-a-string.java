class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        if(needle.length() > haystack.length())
            return -1;
        for(int i = 0;i<= haystack.length() - needle.length();i++)
        {
            for(int j = 0;j<needle.length() && haystack.charAt(i+j) == needle.charAt(j);j++)
            {
                if(j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }
}