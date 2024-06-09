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
    public int findCircleNum(int[][] isConnected) {
        DisjointSet ds = new DisjointSet(isConnected.length);
        for(int i = 0;i<isConnected.length;i++)
        {
            for(int j = 0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j] == 1)
                {
                    ds.unionBySize(i,j);
                }
            }
        }
        int province = 0;
        for(int i = 0;i<isConnected.length;i++)
        {
            if(ds.findUltimateParent(i) == i)
                province++;
        }
        return province;
    }
}