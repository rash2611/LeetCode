class Solution {
    public void dfs(int[] visited, int[][] isConnected, int i,int n)
    {
        visited[i] = 1;
        for(int j = 0;j<n;j++)
        {
            if(visited[j] == 0 && isConnected[i][j] == 1)
            {
                dfs(visited,isConnected,j,n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int province = 0;
        int[] visited = new int[n];
        for(int i = 0;i<n;i++)
        {
            if(visited[i] == 0)
            {
                province++;
                dfs(visited,isConnected,i,n);
            }
        }
        return province;
    }
}