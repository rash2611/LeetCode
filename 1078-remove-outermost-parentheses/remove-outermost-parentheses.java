class Solution {
    public String removeOuterParentheses(String s) {
        if(s.length()<=2)
            return "";
        StringBuilder res = new StringBuilder();
        int opened = 0;
        char c[] = s.toCharArray();
        for(int i = 0;i<c.length;i++)
        {
            if(c[i] == '(')
            {
                if(opened>0)
                    res.append('(');
                opened++;                    
            }
            else
            {
                if(opened>1)
                    res.append(')');
                opened--;
            }
        }
        return res.toString(); 
      }
}