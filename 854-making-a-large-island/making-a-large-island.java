class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0; i<=n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int findUltimateParent(int node)
    {
        if(parent.get(node) == node)
            return node;
        int ulp = findUltimateParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v)
    {
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if(ulp_u == ulp_v)
            return;
        if(size.get(ulp_u) < size.get(ulp_v))
        {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public boolean isValid(int row, int col, int length)
    {
        if(row >= 0 && row< length && col>=0 && col< length)
            return true;
        return false;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        for(int i = 0;i< n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j] == 0)
                    continue;
                int[] drow = {-1,0,1,0};
                int[] dcol = {0,1,0,-1};
                for(int k = 0; k<4;k++)
                {
                    int nrow = drow[k] + i;
                    int ncol = dcol[k] + j;
                    if(isValid(nrow,ncol,n) && grid[nrow][ncol] == 1)
                    {
                        int node = i* n + j;
                        int adjNode = nrow * n + ncol;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }
        int maxi = 0;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j] == 1)
                    continue;
                int drow[] = {-1,0,1,0};
                int dcol[] = {0,1,0,-1};
                HashSet<Integer> component = new HashSet<>();
                for(int k = 0;k<4;k++)
                {
                    int nrow = drow[k] + i;
                    int ncol = dcol[k] + j;
                    if(isValid(nrow,ncol,n) && grid[nrow][ncol] == 1)
                    {
                        component.add(ds.findUltimateParent(nrow * n + ncol));
                    }
                }
                int sizeTotal = 0;
                for(Integer itr : component)
                {
                    sizeTotal+= ds.size.get(itr);
                    maxi = Math.max(maxi, sizeTotal + 1);
                }
            }
        }
        for(int index = 0;index<n*n;index++)
        {
            maxi = Math.max(maxi,ds.size.get(ds.findUltimateParent(index)));
        }
        return maxi;
    }
}