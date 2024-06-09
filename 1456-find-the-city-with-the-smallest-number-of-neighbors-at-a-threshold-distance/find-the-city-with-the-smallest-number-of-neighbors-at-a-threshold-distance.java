class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int city[][] = new int[n][n];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                city[i][j] = (int)(1e9);
                city[i][i] = 0;
            }
        }
        for(int i = 0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            city[u][v] = weight;
            city[v][u] = weight;
        }
        for(int i = 0;i<n;i++)
        {
            for(int j = 0; j<n;j++)
            {
                for(int k = 0;k<n;k++)
                {
                    if(city[j][i] != (int)1e9 && city[i][k] != (int)1e9)
                        city[j][k] = Math.min(city[j][k], city[j][i] + city[i][k]);
                }
            }
        }

        int minCount = Integer.MAX_VALUE;
        int cities = n;
        for(int i = 0;i<n;i++)
        {
            int count = 0;
            for(int j = 0;j<n;j++)
            {
                if(city[i][j] <= distanceThreshold)
                    count++;
            }
            if(count<= minCount)
            {
                minCount = count;
                cities = i;
            }
        }
        return cities;
    }
}