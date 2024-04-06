class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int hash[] = new int[256];
        int maxLength = 0;
        Arrays.fill(hash,-1);
        while(right< s.length())
        {
            if(hash[s.charAt(right)] != -1){
                left = Math.max(left, hash[s.charAt(right)] + 1);
            }
            hash[s.charAt(right)] = right;
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}