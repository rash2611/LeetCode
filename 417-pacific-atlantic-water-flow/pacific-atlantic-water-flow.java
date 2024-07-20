class Solution {
    public void dfs(int row, int col, int[][] heights, int[] drow, int[] dcol, int[][] visited, int m, int n)
    {
        visited[row][col] = 1;
        for(int k = 0;k<4;k++)
        {
            int nrow = drow[k] + row;
            int ncol = dcol[k] + col;
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0 && heights[nrow][ncol] >= heights[row][col])
            {
               dfs(nrow,ncol,heights,drow,dcol,visited,m,n); 
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        if(m == 0 || n == 0)
            return res;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int pacificVisited[][] = new int[m][n];
        int atlanticVisited[][] = new int[m][n];
        for(int i = 0;i<n;i++)
        {
            if(pacificVisited[0][i] == 0)
            {
                dfs(0,i,heights,drow,dcol,pacificVisited,m,n);
            }
            if(atlanticVisited[m-1][i] == 0)
            {
                dfs(m-1,i,heights,drow,dcol,atlanticVisited,m,n);
            }
        }
        for(int i = 0;i<m;i++)
        {
            if(pacificVisited[i][0] == 0)
            {
                dfs(i,0,heights,drow,dcol,pacificVisited,m,n);
            }
            if(atlanticVisited[i][n-1] == 0)
            {
                dfs(i,n-1,heights,drow,dcol,atlanticVisited,m,n);
            }
        }

        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(pacificVisited[i][j] == 1 && atlanticVisited[i][j] == 1)
                {
                    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(i,j));
                    res.add(list);
                }
            }
        }
        return res;
    }
}