class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[numCourses];
        for(int i = 0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++)
        {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty())
        {
            int curr = q.remove();
            topo.add(curr);
            for(int j : adj.get(curr))
            {
                indegree[j]--;
                if(indegree[j] == 0)
                    q.add(j); 
            }
        }
        int res[] = {};
        if(topo.size() == numCourses)
        {
            res = new int[topo.size()];
            for(int i : topo)
            {
                res[i] = topo.get(i);
            }
            return res;

        }
        return res;
    }
}