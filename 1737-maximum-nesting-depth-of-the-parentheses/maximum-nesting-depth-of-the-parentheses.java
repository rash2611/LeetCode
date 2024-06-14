class Solution {
    public int maxDepth(String s) {
        int count = 0, depth = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
            {
                count++;
                depth = Math.max(count,depth);
            }
            else if(s.charAt(i) == ')')
                count--;
        }
        return depth;
    }
}