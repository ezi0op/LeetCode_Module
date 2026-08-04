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
    public ListNode partition(ListNode head, int x) {
        	if (head == null || head.next == null) {
			return head;
		}

		ListNode lessHead = new ListNode(0);
		ListNode afterHead = new ListNode(0);
		ListNode less = lessHead;
		ListNode after = afterHead;
		while (head != null) {
			if (head.val < x) {
				less.next = head;
				less = less.next;
			} else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		after.next = null;
		less.next = afterHead.next;
		return lessHead.next;
    } 
}