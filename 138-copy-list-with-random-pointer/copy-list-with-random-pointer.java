/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void createNewNodes(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
    }
    public void pointRandomPointer(Node head)
    {
        Node temp = head;
        while(temp!= null)
        {
            if(temp.random !=null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
    }
    public Node pointNextPointer(Node head)
    {
        Node dummy = new Node(-1);
        Node res = dummy;
        Node temp = head;
        while(temp!= null)
        {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        createNewNodes(head);
        pointRandomPointer(head);
        Node newHead = pointNextPointer(head);
        return newHead;
    }
}