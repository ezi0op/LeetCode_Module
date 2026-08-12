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
    public ListNode reverseKGroup(ListNode head, int k) {
	if (head == null || head.next == null || k <= 1) {
			return head;
		}

		ListNode temp = head;
		for (int i = 0; i < k; i++) {
			if (temp == null) {
				return head;
			}
			temp = temp.next;
		}
		ListNode newHead = reverseGroup(head, temp);
		head.next = reverseKGroup(temp, k);
		return newHead;

	}

	private static ListNode reverseGroup(ListNode curr, ListNode end) {
		ListNode prev = null;
		while (curr != end) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;

	}
}