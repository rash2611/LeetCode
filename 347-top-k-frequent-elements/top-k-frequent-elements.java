class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int ele : nums)
        {
            map.put(ele, map.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> (a.getValue() - b.getValue()));
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            pq.add(entry);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        int res[] = new int[pq.size()];
        for(int i = 0; i<res.length;i++)
        {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}