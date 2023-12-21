import java.util.*;
class Pair{
    int first;
    int second;
    Pair(int _first, int _second)
    {
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0 ;i<m;i++)
        {
            for(int j = 0;j< n;j++)
            {
                if(i == 0 || j == 0 || i == m-1 || j == n-1)
                {
                    if(grid[i][j] == 1)
                    {
                        q.add(new Pair(i,j));
                        visited[i][j] = 1;
                    }
                    
                }
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            for(int i = 0;i<4;i++)
            {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1)
                {
                    visited[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
        int count = 0;
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j] == 1 && visited[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}