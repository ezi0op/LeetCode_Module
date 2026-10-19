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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
    	if (head == null) {
			return null;
		}
		if (head.next == null) {
			TreeNode node = new TreeNode(head.val);
			return node;
		}
		ListNode mid = findMid(head);
         // Find the node before mid
        ListNode prev = null;
        ListNode curr = head;

        while (curr != mid) {
            prev = curr;
            curr = curr.next;
        }

        // Separate the left half
        if (prev != null) {
            prev.next = null;
        }

		TreeNode root = new TreeNode(mid.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}

	private static ListNode findMid(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}