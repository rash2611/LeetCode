/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for(int i = 0; i< lists.length;i++)
        {
            if(lists[i] != null)
                pq.offer(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(!pq.isEmpty())
        {
            ListNode curr = pq.poll();
            prev.next = curr;
            prev = prev.next;

            if(curr.next!= null)
                pq.offer(curr.next);
        }
        return dummy.next;
    }
}