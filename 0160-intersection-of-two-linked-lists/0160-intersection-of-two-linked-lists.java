/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
			return null;
		}

		ListNode a = headA;
		ListNode b = headB;

		// we are using two pointer approach to find the intersection node of two linked
		// list
		// we are moving both pointers to the next node of the other linked list when
		// they
		// reach the end of their respective linked list
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
    }
}