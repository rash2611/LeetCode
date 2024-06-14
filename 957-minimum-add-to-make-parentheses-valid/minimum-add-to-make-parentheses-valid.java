class Solution {
    public int minAddToMakeValid(String s) {
        int closed = 0, opened = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
                closed++;
            else if(s.charAt(i) == ')' && closed > 0)
            {
                closed--;
            }
            else
                opened++;
        }
        return opened + closed;
    }
}