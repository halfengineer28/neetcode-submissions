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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode rev = slow.next;
        slow.next = null;

        ListNode fresh = reverse(rev);
        ListNode temp = head;
        ListNode temp2 = fresh;

        while (temp != null && temp2 != null){
            ListNode next = temp.next;
            ListNode next2 = temp2.next;
            temp.next = temp2;
            temp2.next = next;
            temp = next;
            temp2 = next2;
        }

        
    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null){

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            

        }
        return prev;
    }
}
