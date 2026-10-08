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
   	private TreeNode first;
	private TreeNode second;
	private TreeNode prev;

	public void recoverTree(TreeNode root) {
		recoverTreeHelperTraverser(root);

		// swap the values of the two nodes
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	private void recoverTreeHelperTraverser(TreeNode root) {
		if (root == null) {
			return;
		}
		// traverse the left subtree and here we are doing inorder traversal of the tree
		// so we will first traverse the left subtree then the root and then the right
		// subtree
		recoverTreeHelperTraverser(root.left);

		// check if prev node is not null and the value of the prev node is greater than
		// the value of the root node then we have found the two nodes that are swapped
		if (prev != null && prev.val > root.val) {
			// if first is null then we will set first to prev and second to root
			if (first == null) {
				first = prev;
			}
			second = root;
		}

		prev = root;
		// traverse the right subtree
		recoverTreeHelperTraverser(root.right);
	}

}