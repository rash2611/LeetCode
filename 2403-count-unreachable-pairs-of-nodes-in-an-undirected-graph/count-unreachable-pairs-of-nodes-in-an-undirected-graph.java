class Solution {
    public int dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = 1;
        int connectedNodes = 1;
        for(Integer adjNode : adj.get(node))
        {
            if(visited[adjNode] == 0)
                connectedNodes+= dfs(adjNode,visited,adj);
        }
        return connectedNodes;
    }
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited = new int[n];
        long unreachablePairs = 0;
        int visitedNodeCount = 0;
        for(int i = 0;i<n;i++)
        {
            if(visited[i] == 0)
            {
                int componentNodeCount = dfs(i, visited, adj);
                unreachablePairs+= (long) visitedNodeCount * componentNodeCount;
                visitedNodeCount+= componentNodeCount;
            }
        }
        return unreachablePairs;
    }
}