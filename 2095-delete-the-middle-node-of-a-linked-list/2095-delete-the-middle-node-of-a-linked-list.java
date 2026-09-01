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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
			return null;
		}
		int count = 0;
        ListNode curr = head;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		

		int mid = count / 2;
        curr=head;
		int i = 0;
		while (curr != null) {
			if (i == mid - 1) {
				curr.next = curr.next.next;
				break;
			}
			curr = curr.next;
			i++;
		}

		return head;
    }
}