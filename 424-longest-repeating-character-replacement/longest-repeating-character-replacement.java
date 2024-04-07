class Solution {
    public int characterReplacement(String s, int k) {
        int hash[] = new int[26];
        int maxFreq = 0, maxLength = 0;
        for(int i = 0;i<s.length();i++)
        {
            Arrays.fill(hash,0);
            for(int j = i;j<s.length();j++)
            {
                hash[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
                int replaceChar = (j-i+1) - maxFreq;
                if(replaceChar <= k)
                    maxLength = Math.max(maxLength, j-i+1);
                else
                    break;
            }
        }
        return maxLength;
    }
}