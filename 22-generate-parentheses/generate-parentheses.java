class Solution {
    public void validParenthesis(List<String> res, int open, int close, String s, int n)
    {
        if(s.length() == 2*n)
        {
            res.add(s);
            return;
        }
        if(open < n)
            validParenthesis(res,open+1,close, s + "(", n);
        if(close < open)
            validParenthesis(res,open,close+1, s + ")", n);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        validParenthesis(res,0,0,"",n);
        return res;
    }
}