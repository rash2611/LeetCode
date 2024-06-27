class Solution {
    public void reverse(int start,int end,char[] ch)
    {
        while(start <= end)
        {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
    public String reverseStr(String s, int k) {
        char ch[] = s.toCharArray();
        int n = s.length();
        for(int i = 0;i<n;i= i + k*2)
        {
            if(i+k-1 <= n-1)
                reverse(i,i+k-1, ch);
            else
                reverse(i,n-1,ch);
        }
        String str = new String(ch);
        return str;
    }
}