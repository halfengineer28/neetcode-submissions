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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null && temp2 != null) {
            int value = temp1.val + temp2.val + carry;
            if (value >= 10) {
                carry = value / 10;
                int a = value % 10;
                curr.next = new ListNode(a);

            } else {
                curr.next = new ListNode(value);
                carry = 0;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
            curr = curr.next;
        }

        while (temp1 != null) {
            int value = temp1.val + carry;
            if (value >= 10) {
                carry = value / 10;
                int a = value % 10;
                curr.next = new ListNode(a);

            } else {
                curr.next = new ListNode(value);
                carry = 0;
            }
            temp1 = temp1.next;
            curr = curr.next;
        }
        while (temp2 != null) {
            int value = temp2.val + carry;
            if (value >= 10) {
                carry = value / 10;
                int a = value % 10;
                curr.next = new ListNode(a);

            } else {
                curr.next = new ListNode(value);
                carry = 0;
            }
            temp2 = temp2.next;
            curr = curr.next;
        }
         if (carry != 0) {
            curr.next = new ListNode(carry);
            
            
        }
        return dummy.next;
    }
}
