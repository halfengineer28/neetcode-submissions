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
        if(head == null){
            return null;
        }
       Node temp = head;
       while(temp != null){
        Node node = new Node(temp.val);
        Node temp2 = temp.next;
        temp.next = node;
        node.next = temp2;
        temp = temp2;
        }

        Node newHead = head.next;

        temp = head;
        while(temp != null){
            
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next; 
        }

        temp = head;
        while(temp != null){
            Node temp2 = temp.next;
            temp.next = temp2.next;
            if(temp2.next != null ){
                 temp2.next = temp2.next.next;

            }
           
            temp = temp.next;
           
        }
        return newHead;
        
    }
}
