class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1;i<n;i++)
        {
            s = countRunLength(s);
        }
        return s;
    }

    public String countRunLength(String s)
    {
        StringBuilder res = new StringBuilder();
        char ch = s.charAt(0);
        int count = 1;
        for(int i = 1; i<s.length();i++)
        {
            if(s.charAt(i) == ch)
            {
                count++;
            }
            else
            {
                res.append(count);
                res.append(ch);
                ch = s.charAt(i);
                count = 1;
            }
        }
        res.append(count);
        res.append(ch);
        return res.toString();
    }
}