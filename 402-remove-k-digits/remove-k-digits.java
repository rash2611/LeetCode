class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length())
            return "0";
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<num.length();i++)
        {
            while(!stack.isEmpty() && k>0 && num.charAt(i) < stack.peek())
            {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k > 0)
        {
            stack.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty())
        {
            res.append(stack.pop());
        }
        res.reverse();
        while(res.length() > 1 && res.charAt(0) == '0')
        {
            res.deleteCharAt(0);
        }
        return res.toString();
    }
}