class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i< s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty())
        {
            Map.Entry e = pq.poll();
            for(int i = 0; i<(int)e.getValue();i++)
            {
                res.append(e.getKey());
            }
        }
        return res.toString();
    }
}