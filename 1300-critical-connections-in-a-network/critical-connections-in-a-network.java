class Solution {
    int timer = 1;
    public void dfs(int node,int parent,int[] tInterval, int[] visited,int[] low,List<List<Integer>> bridges, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = 1;
        tInterval[node] = low[node] = timer;
        timer++;
        for(Integer itr : adj.get(node))
        {
            if(itr == parent)
                continue;
            if(visited[itr] == 0)
            {
                dfs(itr,node,tInterval,visited,low,bridges,adj);
                low[node] = Math.min(low[itr],low[node]);
                if(low[itr] > tInterval[node])
                    bridges.add(Arrays.asList(itr,node));
            }
            else
            {
                low[node] = Math.min(low[itr],low[node]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<connections.size();i++)
        {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<List<Integer>> bridges = new ArrayList<>();
        int tinterval[] = new int[n];
        int low[] = new int[n];
        int visited[] = new int[n];
        dfs(0,-1,tinterval,visited,low,bridges,adj);
        return bridges;
    }
}