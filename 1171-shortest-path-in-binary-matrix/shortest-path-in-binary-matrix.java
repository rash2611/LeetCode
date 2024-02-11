class Tuple{
    int first;
    int second;
    int third;
    Tuple(int _first,int _second, int _third)
    {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;
        if(n== 1)
            return 1;            
        int dist[][] = new int[n][n];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                dist[i][j] = (int) 1e9;
            }
        }
        Queue<Tuple> q = new LinkedList<>();
        dist[0][0] = 1;
        q.add(new Tuple(1,0,0));
        while(!q.isEmpty())
        {
            Tuple itr = q.peek();
            q.remove();
            int dis = itr.first;
            int r = itr.second;
            int c = itr.third;
            for(int drow = -1;drow<=1;drow++)
            {
                for(int dcol = -1;dcol<=1;dcol++)
                {
                    int nrow = r + drow;
                    int ncol = c + dcol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol] == 0 && 1 + dis < dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = 1 + dis;
                        if(nrow == n-1 && ncol == n-1)
                            return dis + 1;
                        q.add(new Tuple(1 + dis, nrow, ncol));
                    }
                }
            }
        }
        return -1;
    }
}