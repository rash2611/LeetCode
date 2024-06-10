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
    public int removeStones(int[][] stones) {
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for(int i = 0;i<stones.length;i++)
        {
            int nrow = stones[i][0];
            int ncol = stones[i][1];
            maxRow = Math.max(nrow, maxRow);
            maxCol = Math.max(ncol, maxCol);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<stones.length;i++)
        {
            int drow = stones[i][0];
            int dcol = stones[i][1] + maxRow + 1;
            ds.unionBySize(drow,dcol);
            map.put(drow,1);
            map.put(dcol,1);
        }

        int comp = 0;
        for(Map.Entry<Integer, Integer> itr : map.entrySet())
        {
            if(ds.findUltimateParent(itr.getKey()) == itr.getKey())
                comp++;
        }
        return stones.length - comp;
    }
}