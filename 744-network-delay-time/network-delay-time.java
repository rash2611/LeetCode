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
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m = times.length;
        for(int i = 0;i<m;i++)
        {
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.first - y.first);
        pq.add(new Pair(0,k));
        int dist[] = new int[n+1];
        for(int i = 1;i<=n;i++)
            dist[i] = (int) 1e9;
        dist[k] = 0;
        while(!pq.isEmpty())
        {
            Pair itr = pq.peek();
            pq.remove();
            int time = itr.first;
            int node = itr.second;
            for(Pair i : adj.get(node))
            {
                int adjNode = i.first;
                int edgT = i.second;
                if(edgT + time < dist[adjNode])
                {
                    dist[adjNode] = edgT + time;
                    pq.add(new Pair(edgT + time, adjNode));
                }
            }
        }
        int maxTime = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++)
        {
            if(dist[i] == (int) 1e9)
                return -1;
            else
                maxTime = Math.max(maxTime,dist[i]);
        }
        return maxTime;
    }
}