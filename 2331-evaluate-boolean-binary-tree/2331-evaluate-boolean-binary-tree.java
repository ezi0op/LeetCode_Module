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
    public boolean evaluateTree(TreeNode root) {
        
    return evaluateTreeHelper(root);
	}

	// helper method to evaluate the binary tree
	private boolean evaluateTreeHelper(TreeNode root) {
		// if root is false or true then return the value of root
		if (root.val == 0 || root.val == 1) {
			return root.val == 1;
			// if root OR then evaluate the left and right subtree with respect OR and
			// return the result
		} else if (root.val == 2) {
			return evaluateTreeHelper(root.left) || evaluateTreeHelper(root.right);
			// if root AND then evaluate the left and right subtree with respect AND and
			// return the result
		} else if (root.val == 3) {
			return evaluateTreeHelper(root.left) && evaluateTreeHelper(root.right);
		}
		return false;

	}
}