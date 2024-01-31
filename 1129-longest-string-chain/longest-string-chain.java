class Solution {
    public boolean compare(String word1, String word2)
    {
        if(word1.length() != word2.length() + 1)
            return false;
        int first = 0;
        int second = 0;
        while(first< word1.length()){
            if(second < word2.length() && word1.charAt(first) == word2.charAt(second))
            {
                first++;
                second++;
            }
            else
            {
                first++;
            }
        }
        return first == word1.length() && second == word2.length();
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        for(int i = 1;i<n;i++)
        {
            for(int prev = 0;prev<i;prev++)
            {
                if(compare(words[i],words[prev]) && 1+ dp[prev] >  dp[i])
                {
                    dp[i] = 1 + dp[prev];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}