class Solution {
    public boolean isVowel(char ch)
    {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public String reverseVowels(String s) {
        if(s.length() <= 1)
            return s;
        char ch[] = s.toCharArray();
        int i = 0, j = s.length() - 1;

        while(i < j)
        {
            boolean vowelStart = isVowel(ch[i]);
            boolean vowelEnd = isVowel(ch[j]);
            if(vowelStart && vowelEnd)
            {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;j--;
            }
            else if(!vowelStart)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return new String(ch);
    }
}