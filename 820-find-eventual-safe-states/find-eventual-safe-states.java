class Solution {
    public boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited, int[] check)
    {
        visited[i] = 1;
        pathVisited[i] = 1;
        check[i] = 0;
        for(Integer itr: adj.get(i))
        {
            if(visited[itr] == 0)
            {
                if(dfs(itr, adj, visited, pathVisited, check))
                    return true;
            }
            else if(pathVisited[itr] == 1)
                return true;
        }
        check[i] = 1;
        pathVisited[i] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i = 0; i<n;i++)
        {
            adj.add(new ArrayList<>());
            for(int j : graph[i])
                adj.get(i).add(j);
        }
        int visited[] = new int[n];
        int pathVisited[] = new int[n];
        int check[] = new int[n];
        for(int i = 0;i<n;i++)
        {
            if(visited[i] == 0)
            {
                dfs(i,adj,visited,pathVisited, check);
            }
        }
        List<Integer> safeNode = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            if(check[i] == 1)
                safeNode.add(i);
        }
        return safeNode;
    }
}