import java.util.*;
class Pair {
    long first;
    long second;
    Pair(long _first, long _second)
    {
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m = roads.length;
        for(int i = 0;i<m;i++)
        {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Long.compare(x.first,y.first));
        pq.add(new Pair(0,0));
        long dist[] = new long[n];
        long ways[] = new long[n];
        for(int i = 0;i<n;i++){
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        long mod = (long)(1e9 + 7);
        while(!pq.isEmpty())
        {
            Pair itr = pq.peek();
            pq.remove();
            long dis = itr.first;
            long node = itr.second;
            for(Pair i : adj.get((int)node))
            {
                long adjNode = i.first;
                long edgW = i.second;
                if(edgW + dis < dist[(int)adjNode])
                {
                    dist[(int)adjNode] = edgW + dis;
                    pq.add(new Pair(edgW + dis,adjNode));
                    ways[(int)adjNode] = ways[(int)node];
                }
                else if(edgW + dis == dist[(int)adjNode])
                {
                    ways[(int)adjNode] = (ways[(int)adjNode] + ways[(int)node]) % mod;
                }
            }
        }
        return (int)(ways[n-1] % mod);
    }
}