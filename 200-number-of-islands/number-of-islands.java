class Solution {
    public void dfs(char[][] grid,int[][] visited, int currrow, int currcol, int row, int col, int[] drow, int[] dcol)
    {
        visited[currrow][currcol] = 1;
        for(int i = 0;i < 4;i++)
        {
            int nrow = currrow + drow[i];
            int ncol = currcol + dcol[i];
            if(nrow >=0 && nrow < row && ncol >= 0 && ncol < col && visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1')
            {
                dfs(grid,visited,nrow,ncol,row,col,drow,dcol);
            }
        }
    }
    public int numIslands(char[][] grid) {
         int m = grid.length;
         int n = grid[0].length;
         int island = 0;
         int visited[][] = new int[m][n];
         int[] drow = {-1,0,1,0};
         int[] dcol = {0,1,0,-1};
         for(int i = 0; i<m;i++)
         {
            for(int j = 0; j<n;j++)
            {
                if(visited[i][j] == 0 && grid[i][j] == '1')
                {
                    island++;
                    dfs(grid,visited,i,j,m,n,drow,dcol);
                }
            }
         }
         return island;
    }
}