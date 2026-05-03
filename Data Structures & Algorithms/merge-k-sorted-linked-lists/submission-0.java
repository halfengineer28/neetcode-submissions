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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int n = lists.length;

        for (int i = 1; i < n; i++){
           lists[i] = merge(lists[i-1], lists[i]);
        }
        return lists[lists.length-1];

    }
    public ListNode merge (ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else{
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }

        }
        if (l1 != null){
            temp.next = l1;
        }else{
            temp.next = l2;
        }

        return dummy.next;
    }
}
