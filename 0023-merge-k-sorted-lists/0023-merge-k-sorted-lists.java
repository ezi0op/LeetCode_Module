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
    public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		ListNode s = null;
		ListNode e = null;

		for (ListNode list : lists) {
			if (list == null) {
				continue;
			}
			if (s == null) {
				s = list;
				e = list;
			} else {
				e.next = list;
			}
			while (e.next != null) {
				e = e.next;
			}
		}

		// sort the merged list using merge sort
		return mergeKSortList(s);

	}

	private static ListNode mergeKSortList(ListNode s) {
		if (s == null || s.next == null) {
			return s;
		}
		ListNode mid = midK(s);
		ListNode midNext = mid.next;
		mid.next = null;
		ListNode left = mergeKSortList(s);
		ListNode right = mergeKSortList(midNext);

		return mergeK(left, right);
	}

	private static ListNode mergeK(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				curr.next = left;
				left = left.next;
			} else {
				curr.next = right;
				right = right.next;
			}
			curr = curr.next;
		}
		curr.next = left != null ? left : right;
		return dummy.next;
	}

	private static ListNode midK(ListNode s) {
		ListNode s1 = s;
		ListNode f = s;
		while (f != null && f.next != null) {
			s1 = s1.next;
			f = f.next.next;
		}

		return s;
	}
}