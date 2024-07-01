class Solution {
    int timer = 1;
    public void dfs(int node, int parent,int[] visited, int[] insertionTime, int[] low, List<List<Integer>> adj, List<List<Integer>> bridges)
    {
        visited[node] = 1;
        insertionTime[node] = low[node] = timer;
        timer++;
        for(Integer adjNode : adj.get(node))
        {
            if(adjNode == parent)
                continue;
            if(visited[adjNode] == 0)
            {
                dfs(adjNode,node,visited,insertionTime,low,adj,bridges);
                low[node] = Math.min(low[node], low[adjNode]);
                if(low[adjNode] > insertionTime[node])
                    bridges.add(Arrays.asList(node,adjNode));
            }
            else
            {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<connections.size();i++)
        {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int visited[] = new int[n];
        int insertionTime[] = new int[n];
        int low[] = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,visited, insertionTime,low, adj,bridges);
        return bridges;
    }
}