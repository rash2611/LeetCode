class Tuple {
    int first,second,third;
    Tuple(int first, int second, int third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int dist[][] = new int[n][m];
        for(int i = 0;i<n;i++)
        {
            Arrays.fill(dist[i],(int)1e9);
        }
        dist[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> (a.first - b.first));
        pq.offer(new Tuple(0,0,0));
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(!pq.isEmpty())
        {
            int distance = pq.peek().first;
            int row = pq.peek().second;
            int column = pq.peek().third;
            pq.poll();
            if(row == n-1 && column == m-1)
                return distance;
            for(int i = 0;i<4;i++)
            {
                int nrow = row + drow[i];
                int ncol = column + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m)
                {
                    int newEffort = Math.max(Math.abs(heights[nrow][ncol] - heights[row][column]), distance);
                    if(newEffort < dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Tuple(newEffort, nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}
