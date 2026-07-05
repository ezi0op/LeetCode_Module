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
    public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = getMid(head);
		ListNode rightToMid = mid.next;
		mid.next = null;

		ListNode left = sortList(head);
		ListNode right = sortList(rightToMid);
		return merge(left, right);
	}

	private static ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (left != null && right != null) {
			if (left.val <= right.val) {
				curr.next = left;
				left = left.next;

			} else {
				curr.next = right;
				right = right.next;

			}
			curr = curr.next;

		}

		if (left != null) {
			curr.next = left;
		}

		if (right != null) {
			curr.next = right;

		}

		return dummy.next;
	}
}