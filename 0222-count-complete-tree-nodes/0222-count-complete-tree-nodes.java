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
    public int countNodes(TreeNode root) {
        
		if (root == null) {
			return 0;
		}

		// find the depth of the left and right subtree
		int left = leftDepth(root);
		int right = rightDepth(root);

		// if left and right depth are equal then we can use the formula 2^depth - 1 to
		// find the number of nodes in the tree
		if (left == right) {
			return (1 << left) - 1;
		}

		// recursively count the number of nodes W the left and right subtree and add 1
		// for the current node
		return 1 + countNodes(root.left) + countNodes(root.right);

	}

	// method to find the depth of the right subtree
	private int rightDepth(TreeNode right) {
		int depth = 0;
		// loop until right is not null and increment depth by 1 and set right to
		// right.right
		while (right != null) {
			right = right.right;
			depth++;
		}
		return depth;
	}

	// method to find the depth of the left subtree
	private int leftDepth(TreeNode left) {
		int depth = 0;
		// loop until left is not null and increment depth by 1 and set left to
		// left.left
		while (left != null) {
			left = left.left;
			depth++;
		}
		return depth;
	}
}