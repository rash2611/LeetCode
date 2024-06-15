class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : tasks)
        {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
        pq.addAll(map.entrySet());

        int count = 0;
        while(!pq.isEmpty())
        {
            int intervals = n + 1;
            List<Map.Entry<Character,Integer>> list = new ArrayList<>();
            while(intervals > 0 && !pq.isEmpty())
            {
                Map.Entry<Character,Integer> entry = pq.poll();
                entry.setValue(entry.getValue() - 1);
                list.add(entry);
                intervals--;
                count++;
            }

            for(Map.Entry<Character,Integer> entry : list)
            {
                if(entry.getValue() > 0)
                    pq.offer(entry);
            }

            if(pq.isEmpty())
                break;
            count+=intervals;
        }
        return count;
    }
}