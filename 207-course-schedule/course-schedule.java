class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int topoCount = 0;
        for(int i = 0;i<numCourses;i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i< prerequisites.length; i++)
        {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adjList.get(b).add(a);
            indegree[a]++;
        }
        for(int i = 0; i< indegree.length;i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            topoCount++;
            for(int i = 0; i<adjList.get(node).size(); i++)
            {
                int adjNode = adjList.get(node).get(i);
                indegree[adjNode]--;
                if(indegree[adjNode] == 0)
                {
                    queue.add(adjNode);
                }
            }
        }
        if(topoCount == numCourses)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}