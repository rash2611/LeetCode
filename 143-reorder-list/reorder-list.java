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
    public ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode newHead = null;
        while(head!= null)
        {
            ListNode headNext = head.next;
            head.next = newHead;
            newHead = head;
            head = headNext;
        }
        return newHead;
    }
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode revHead = reverse(midNext);
        ListNode head1 = head;
        while(head1 != null && revHead != null)
        {
            ListNode head1Next = head1.next;
            ListNode revNext = revHead.next;
            head1.next = revHead;
            revHead.next = head1Next;
            head1 = head1Next;
            revHead = revNext;
        }
        return;
    }
}