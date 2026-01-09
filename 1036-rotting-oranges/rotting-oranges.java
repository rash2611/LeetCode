import java.util.*;
class Pair{
    int row,column,time;
    Pair(int _row,int _column,int _time)
    {
        this.row = _row;
        this.column = _column;
        this.time = _time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int visited[][] = new int[row][column];
        int countFresh = 0;
        for(int i = 0;i<row;i++)
        {
            for(int j = 0;j<column;j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 1;
                }
                if(grid[i][j] == 1)
                {
                    countFresh++;
                }
            }
        }
        int maxTime = 0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int count = 0;
        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().column;
            int t = q.peek().time;
            maxTime = Math.max(maxTime,t);
            q.poll();
            for(int i = 0;i<4;i++)
            {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<row && ncol>=0 && ncol<column && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1)
                {
                    q.add(new Pair(nrow,ncol,t+1));
                    visited[nrow][ncol] = 1;
                    count++;
                }
            }


        }
        if(count != countFresh)
            return -1;
        return maxTime;
    }
}
