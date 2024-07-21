class Pair{
    int room;
    int end;
    Pair(int room, int end)
    {
        this.room = room;
        this.end = end;
    }
}
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int rooms = 0;
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.end - b.end));
        for(int i = 0;i<intervals.length;i++)
        {
            if(pq.isEmpty() || pq.peek().end > intervals[i][0])
            {
                rooms++;
                pq.offer(new Pair(rooms, intervals[i][1]));
            }
            else if(pq.peek().end <= intervals[i][0])
            {
                int currRoom = pq.peek().room;
                pq.poll();
                pq.offer(new Pair(currRoom, intervals[i][1]));
            }
        }
        return rooms;
    }
}