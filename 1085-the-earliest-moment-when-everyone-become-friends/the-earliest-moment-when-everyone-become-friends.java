class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    public DisjointSet(int n)
    {
        for(int i = 0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int ulp(int node)
    {
        if(parent.get(node) == node)
            return node;
        int ultimateParent = ulp(parent.get(node));
        parent.set(node,ultimateParent);
        return parent.get(node);
    }

    public void unionBySize(int u, int v)
    {
        int ulp_u = ulp(u);
        int ulp_v = ulp(v);
        if(ulp_u == ulp_v)
            return;
        if(size.get(ulp_u) <= size.get(ulp_v))
        {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else
        {
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, ((a,b) -> (a[0] - b[0])));
        DisjointSet ds = new DisjointSet(n);
        int timestamp = -1;
        for(int i = 0;i<logs.length;i++)
        {
            int u = logs[i][1];
            int v = logs[i][2];
            int time = logs[i][0];
            if(ds.ulp(u) != ds.ulp(v))
            {
                ds.unionBySize(u,v);
                timestamp = time;
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++)
        {
            if(ds.ulp(i) == i)
            {
                count++;
                if(count > 1)
                    return -1;
            }
        }
        return timestamp;
    }
}