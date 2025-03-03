class Tuple{
    int r,c,dist;
    Tuple(int r,int c, int dist)
    {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] visited = new int[row][col];
        int[][] distance = new int[row][col];
        Queue<Tuple> q = new LinkedList<>();
        for(int i = 0;i<row;i++)
        {
            for(int j = 0; j< col;j++)
            {
                if(mat[i][j] == 0)
                {
                    visited[i][j] = 1;
                    q.add(new Tuple(i,j,0));
                }
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(!q.isEmpty())
        {
            int r = q.peek().r;
            int c = q.peek().c;
            int steps = q.peek().dist;
            q.poll();
            for(int i = 0;i<4;i++)
            {
                int nrow = drow[i] + r;
                int ncol = dcol[i] + c;
                if(nrow >= 0 && nrow < row && ncol >= 0 && ncol < col && visited[nrow][ncol] == 0)
                {
                    visited[nrow][ncol] = 1;
                    q.add(new Tuple(nrow,ncol,steps + 1));
                    distance[nrow][ncol] = steps + 1;
                }
            }
        }
        return distance;
    }
}