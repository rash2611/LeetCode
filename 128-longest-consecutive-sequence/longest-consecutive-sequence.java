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
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        DisjointSet ds = new DisjointSet(n);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                if(map.containsKey(nums[i] - 1))
                {
                    ds.unionBySize(map.get(nums[i] - 1), i);
                }
                if(map.containsKey(nums[i] + 1))
                {
                    ds.unionBySize(map.get(nums[i] + 1), i);
                }
                map.put(nums[i], i);
            }
            else
                continue;
        }
        int maxLength = 0;
        for(int i = 0;i<n;i++)
        {
            if(ds.parent.get(i) == i)
            {
                maxLength = Math.max(maxLength, ds.size.get(i));
            }
        }
        return maxLength;
    }
}