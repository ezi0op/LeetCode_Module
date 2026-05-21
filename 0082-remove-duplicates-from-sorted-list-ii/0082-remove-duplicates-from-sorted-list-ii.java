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
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode start = head;
        while (start!=null&&start.next != null ) {
            if (start.val == start.next.val) {
                while (start.next != null && start.val == start.next.val) {
                    start = start.next;
                }

                prev.next = start.next;

            } else {
                prev = prev.next;
            }
            start = start.next;
        }
        return dummy.next;
    }
}