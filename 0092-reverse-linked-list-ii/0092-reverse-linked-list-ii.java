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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
  if (left == right || head == null || head.next == null) {
			return head;
		}

		ListNode start = null;
		ListNode curr = head;

		for (int i = 1; i < left ; i++) {
			start = curr;
			curr = curr.next;
		}

		ListNode prev = null;
		ListNode next = curr.next;
		ListNode temp = curr;
		for (int i = 0; curr != null && i < right - left + 1; i++) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null) {
				next = curr.next;
			}
			temp.next = curr;

		}

		// here we hav to link end of rev to last element of list node
		if (start != null) {
			start.next = prev;
		} else {
			head = prev;
		}

		return head;

	}

}