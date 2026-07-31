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
        
  if (head == null || head.next == null) {
			return;
		}
		ListNode start = head;
		ListNode mid = midOrder(head);

		ListNode midNext = mid.next;
		mid.next = null;

		ListNode revEnd = reverseOrder(midNext);
		while (revEnd != null) {
			ListNode temp = start.next;
			ListNode temp2 = revEnd.next;
			start.next = revEnd;
			revEnd.next = temp;
			start = temp;
			revEnd = temp2;
		}

	}

	private ListNode midOrder(ListNode head) {
		ListNode s = head;
		ListNode f = head.next;
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
		}
		return s;
	}

	private ListNode reverseOrder(ListNode mid) {
		ListNode prev = null;
		ListNode curr = mid;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}