import java.util.*;
class Pair{
    int first;
    int second;
    int third;
    Pair(int _first, int _second, int _third)
    {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int[][] visited = new int[row][column];
        int[][] distance = new int[row][column];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<row;i++)
        {
            for(int j = 0;j<column;j++)
            {
                if(mat[i][j] == 0)
                {
                    visited[i][j] = 1;
                    q.add(new Pair(i,j,0));
                }
                else
                {
                    visited[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty())
        {
            int r = q.peek().first;
            int c = q.peek().second;
            int steps = q.peek().third;
            distance[r][c] = steps;
            q.poll();
            int[] drow = {-1,0,1,0};
            int[] dcol = {0,1,0,-1};
            for(int i = 0;i<4;i++)
            {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<row && ncol>=0 && ncol<column && visited[nrow][ncol] == 0)
                {
                    visited[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return distance;
    }
}