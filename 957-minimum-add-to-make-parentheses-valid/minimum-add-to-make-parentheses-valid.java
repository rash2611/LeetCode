class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
                stack.push('(');
            else if(s.charAt(i) == ')')
            {
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    count++;
            }
        }
        return count + stack.size();
    }
}