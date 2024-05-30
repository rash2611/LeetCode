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
    public void reverse(ListNode temp){
        ListNode prev = null;
        while(temp!=null)
        {
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

    }
    public ListNode findKthNode(ListNode temp, int k)
    {
        ListNode curr = temp;
        k--;
        while(curr!=null && k>0)
        {
            curr = curr.next;
            k--;
        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while(temp!=null)
        {
            ListNode kthNode = findKthNode(temp,k);
            if(kthNode!= null)
            {
                nextNode  = kthNode.next;
                kthNode.next = null;
            }
            else{
                if(prevNode != null)
                {
                    prevNode.next = temp;
                    break;
                }
            }
            reverse(temp);
            if(temp == head)
            {
                head = kthNode;
            }
            else
            {
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}