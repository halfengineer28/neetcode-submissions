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
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node dummy = new Node(-1);
        dummy.next = curr;

        while (curr != null) {
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = curr.next.next;
        }

        curr = head;

        while (curr != null && curr.next != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            } else {
                curr.next.random = null;
            }
            curr = curr.next.next;
        }

        Node dummy2 = new Node(-1);
        Node res = dummy2;
        curr = head;

        

        while (curr != null && curr.next != null){
            res.next = curr.next;
            curr.next = curr.next.next;
            res = res.next;
            curr = curr.next;
        }
        return dummy2.next;
    }
}
