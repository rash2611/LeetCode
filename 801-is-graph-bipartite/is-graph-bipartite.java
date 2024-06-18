class Solution {
    public boolean dfs(int node, int color, int[] colors,int[][] graph)
    {
        colors[node] = color;
        for(int num : graph[node])
        {
            if(colors[num] == -1)
            {
                if(dfs(num,1 - color, colors, graph) == false)
                    return false;
            }
            else if(colors[num] == color)
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);
        for(int i = 0;i<graph.length;i++)
        {
            if(colors[i] == -1)
            {
                if(dfs(i,0,colors,graph) == false)
                    return false;
            }
        }
        return true;
    }
}