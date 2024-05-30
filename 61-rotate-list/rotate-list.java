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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int length = 1;
        ListNode tail = head;
        while(tail.next!=null)
        {
            length++;
            tail = tail.next;
        }
        k = k % length;
        if(k == 0)
        {
            return head;
        }
        tail.next = head;
        ListNode temp = head;
        int count = 1;
        while(count != length - k)
        {
            count++;
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}