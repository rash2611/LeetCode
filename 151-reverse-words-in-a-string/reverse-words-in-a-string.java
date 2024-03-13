class Solution {
    public String reverseWords(String s) {
        String rev = "";
        String word = "";
        for(int i = 0; i<s.length();i++)
        {
            if(s.charAt(i) == ' ')
            {
                if(!word.isEmpty()){
                    rev = " " + word + rev;
                    word = "";
                }
            }
            else
            {
                word = word + s.charAt(i);
            }
        }
        rev = word + rev;
        return rev.trim();
    }
}