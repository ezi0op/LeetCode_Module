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
    int min = Integer.MAX_VALUE;
	int last = -1;
    public int getMinimumDifference(TreeNode root) {
        
    inOrderMinDiff(root);
		return min;

	}

	// we are using inorder traversal of the tree to find the minimum difference
	// between any two nodes in a binary search tree
	private void inOrderMinDiff(TreeNode root) {
		if (root == null) {
			return;
		}

		// traverse left subtree
		inOrderMinDiff(root.left);
		// assign the minimum difference between the current node and the last node to
		// min
		if (last != -1) {
			min = Math.min(min, root.val - last);
		}
		// assign the value of the current node to last
		last = root.val;
		// traverse right subtree
		inOrderMinDiff(root.right);
	}
}