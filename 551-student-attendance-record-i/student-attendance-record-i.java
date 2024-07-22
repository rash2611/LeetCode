class Solution {
    public boolean checkRecord(String s) {
        int countA = 0, countL = 0;
        for(int i = 0; i< s.length();i++)
        {
            if(s.charAt(i) == 'A')
                countA++;
            if(s.charAt(i) == 'L')
                countL++;
            else 
                countL = 0;
            if(countA > 1 || countL > 2)
                return false;
        }
        return true;
    }
}