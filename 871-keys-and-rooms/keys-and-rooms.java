class Solution {
    public void dfs(List<List<Integer>> rooms, int[] visited, int node)
	{
		for(Integer adjNode : rooms.get(node))
		{
			if(visited[adjNode] == 0)
			{
				visited[adjNode] = 1;
				dfs(rooms, visited, adjNode);
			}
		}
	}

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
		int[] visited = new int[n];
		visited[0] = 1;
		for(int i = 0; i< n;i++)
		{
			if(visited[i] == 1)
			{
				dfs(rooms,visited,i);
			}
			else
				return false;
		}
		return true;

    }
}