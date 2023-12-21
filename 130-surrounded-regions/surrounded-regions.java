class Solution {
    public void dfs(char[][] board, int[][] visited, int row,int column, int cellrow,int cellcol, int[] deltarow, int[] deltacol)
    {
        visited[cellrow][cellcol] = 1;
        for(int i = 0;i<4;i++)
        {
            int nrow = cellrow + deltarow[i];
            int ncol = cellcol + deltacol[i];
            if(nrow>=0 && nrow<row && ncol>=0 && ncol<column && visited[nrow][ncol] == 0 && board[nrow][ncol] == 'O')
            {
                dfs(board,visited,row,column,nrow,ncol,deltarow,deltacol);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int deltarow[] = {-1,0,1,0};
        int deltacol[] = {0,1,0,-1};
        int[][] visited = new int[m][n];
        for(int i = 0;i<n;i++)
        {
            if(visited[0][i] == 0 && board[0][i] == 'O')
            {
                dfs(board,visited,m,n,0,i,deltarow,deltacol);
            }
            if(visited[m-1][i] == 0 && board[m-1][i] == 'O')
            {
                dfs(board,visited,m,n,m-1,i,deltarow,deltacol);
            }
        }
        for(int i = 0; i<m;i++)
        {
            if(visited[i][0] == 0 && board[i][0] == 'O')
            {
                dfs(board,visited,m,n,i,0,deltarow,deltacol);
            }
            if(visited[i][n-1] == 0 && board[i][n-1] == 'O')
            {
                dfs(board,visited,m,n,i,n-1,deltarow,deltacol);
            }
        }

        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(visited[i][j] == 0 && board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
}