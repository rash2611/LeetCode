class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] rank = new String[score.length];
        int n = score.length;
        int[][] pair = new int[n][2];
        for(int i = 0;i<n;i++)
        {
            pair[i][0] = score[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, (a,b) -> (b[0] -a[0]));
        for(int i = 0;i<pair.length;i++)
        {
            if(i==0)
                rank[pair[i][1]] = "Gold Medal";
            else if(i == 1)
                rank[pair[i][1]] = "Silver Medal";
            else if(i == 2)
                rank[pair[i][1]] = "Bronze Medal";
            else
                rank[pair[i][1]] = String.valueOf(i + 1);
        }
        return rank;
    }
}