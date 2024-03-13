class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        String str = t;
        for(int i = 0; i< s.length();i++)
        {
            int index = str.indexOf(s.charAt(i));
            if(index == -1)
                return false;
            str = str.substring(0,index) + str.substring(index+1, str.length());
        }
        return true;
    }
}