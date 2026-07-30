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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode f = dummy;
		ListNode s = dummy;
		// move fast pointer n+1 steps ahead of slow pointer means until we reach target
		// node
		for (int i = 0; i < n + 1; i++) {
			f = f.next;
		}
		// move both pointers until fast pointer reaches the end of the list
		while (f != null) {
			f = f.next;
			s = s.next;
		}
		s.next = s.next.next;
		return dummy.next;
    }
}