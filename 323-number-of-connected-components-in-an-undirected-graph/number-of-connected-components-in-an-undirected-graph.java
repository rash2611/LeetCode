class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adjList,int[] visited)
    {
        visited[node] = 1;
        for(int itr: adjList.get(node))
        {
            if(visited[itr] == 0)
            {
                dfs(itr,adjList,visited);
            }
        }
    }
    public void createAdjacencyList(int n, ArrayList<ArrayList<Integer>> adjList,int[][] edges)
    {
        for(int i = 0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i< edges.length; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }
    public int countComponents(int n, int[][] edges) {
        int connectedComponents = 0;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        createAdjacencyList(n, adjList, edges);
        int visited[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            if(visited[i] == 0)
            {
                connectedComponents++;
                dfs(i, adjList, visited);
            }
        }
        return connectedComponents;
    }
}