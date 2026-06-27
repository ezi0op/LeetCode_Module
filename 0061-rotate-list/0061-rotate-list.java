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
    public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;

		}
		ListNode temp = head;
		int len = 1;
		// get the length of the list
		while (temp.next != null) {
			temp = temp.next;
			len++;

		}

		// reduce k to within the length of the list
		// ex if k is 7 and length is 5 then we need to rotate only 2 times
		k = k % len;
		if (k == 0) {
			return head;
		}

		// make list cicular
		temp.next = head;

		// find last node to break the circular list
		int stepsToNewHead = len - k;
		ListNode newLast = head;

		for (int i = 1; i < stepsToNewHead; i++) {
			newLast = newLast.next;
		}

		ListNode newHead = newLast.next;
		newLast.next = null;
		return newHead;

	}
}