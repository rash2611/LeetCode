class Solution {
    public void dfs(int row, int col, int[][] visited, char grid[][], int[] drow, int[] dcol, int m, int n)
    {
        visited[row][col] = 1;
        for(int k = 0; k<4;k++)
        {
            int nrow = drow[k] + row;
            int ncol = dcol[k] + col;
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1')
            {
                dfs(nrow, ncol, visited, grid, drow, dcol, m, n);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        if(n == 0)
            return 0;
        int component = 0;
        int[][] visited = new int[m][n];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(visited[i][j] == 0 && grid[i][j] == '1')
                {
                    component++;
                    dfs(i,j,visited,grid,drow,dcol,m,n);
                }
            }
        }
        return component;
    }
}