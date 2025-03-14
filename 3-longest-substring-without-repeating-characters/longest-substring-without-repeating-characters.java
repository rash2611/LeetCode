class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i = 0; i< s.length();i++)
        {
            int[] hash = new int[256];
            int count = 0;
            for(int j = i; j <s.length();j++)
            {
                char ch = s.charAt(j);
                if(hash[ch] == 1)
                    break;
                hash[ch]++;
                count++;
            }
            maxLength = Math.max(maxLength,count);
        }
        return maxLength;
    }
}

// aabbcadda
// 4

// aaaaaaaaaa
// 1

// aabbccdd 
// 2