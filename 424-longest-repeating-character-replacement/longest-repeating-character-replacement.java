class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxFreq = 0, maxLength = 0;
        int[] hash = new int[26];
        while(right<s.length())
        {
            hash[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);
            while((right - left+1) - maxFreq > k)
            {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}