/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int findLength(ListNode head){
        int length = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            length++;
            temp = temp.next;
        }
        return length;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = findLength(headA);
        int lengthB = findLength(headB);
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null && tempB != null)
        {
            if(lengthA < lengthB)
            {
                tempB = tempB.next;
                lengthB--;
            }
            else if(lengthA > lengthB)
            {
                tempA = tempA.next;
                lengthA--;
            }
            else
            {
                if(tempA == tempB)
                    return tempA;
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        return null;
    }
}