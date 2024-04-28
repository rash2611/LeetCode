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
    public int findLength(ListNode head)
    {
        int length = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            length++;
            temp = temp.next;
        }
        return length;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int length = findLength(head);
        k = k % length;
        while(k>0)
        {
            ListNode prev = null;
            ListNode curr = head;
            for(int i = 1;i<length;i++)
            {
                if(curr!=null)
                {
                    prev = curr;
                    curr = curr.next;
                }
            }
            if(prev!=null)
            {
                prev.next = null;
                curr.next = head;
                head = curr;
            }
            k--;
        }
        return head;
    }
}