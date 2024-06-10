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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet ds = new DisjointSet(accounts.size());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<accounts.size();i++)
        {
            for(int j = 1; j<accounts.get(i).size();j++)
            {
                if(map.containsKey(accounts.get(i).get(j)))
                {
                    ds.unionBySize(map.get(accounts.get(i).get(j)), i);
                }
                else
                {
                    map.put(accounts.get(i).get(j), i);
                }
            }
        }

        List<List<String>> mergeMails = new ArrayList<>();
        for(int i = 0;i<accounts.size();i++)
        {
            mergeMails.add(new ArrayList<>());
        }
        for(Map.Entry<String, Integer> itr : map.entrySet())
        {
            String mail = itr.getKey();
            int node = ds.findUltimateParent(itr.getValue());
            mergeMails.get(node).add(mail);
        }

        List<List<String>> res = new ArrayList<>();
        for(int i = 0;i<accounts.size();i++)
        {
            if(mergeMails.get(i).size() == 0)
                continue;
            Collections.sort(mergeMails.get(i));
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String s : mergeMails.get(i))
            {
                temp.add(s);
            }
            res.add(temp);
        }
        return res;
    }
}