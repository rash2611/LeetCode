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
class Tuple{
    int first, second, third;
    Tuple(int _first, int _second, int _third)
    {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int dist[] = new int[n];
        for(int i = 0;i<n;i++)
            dist[i] = (int) 1e9;
        dist[src] = 0;
        while(!q.isEmpty())
        {
            Tuple itr = q.peek();
            q.remove();
            int stops = itr.first;
            int node = itr.second;
            int dis = itr.third;
            if(stops > k)
                continue;
            for(int i = 0; i<adj.get(node).size();i++)
            {
                int adjNode = adj.get(node).get(i).first;
                int edgW = adj.get(node).get(i).second;
                if(stops <= k && edgW + dis < dist[adjNode])
                {
                    dist[adjNode] = edgW + dis;
                    q.add(new Tuple(1 + stops, adjNode, edgW + dis));
                }
            }
        }
        if(dist[dst] != (int)(1e9))
            return dist[dst];
        return -1;
    }
}