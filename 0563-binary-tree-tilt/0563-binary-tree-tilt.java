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
    int totalTilt=0;
    public int findTilt(TreeNode root) {
        
		calculateTilt(root);
		return totalTilt;
	}

	private int calculateTilt(TreeNode root) {
		if (root == null) {
			return 0;
		}

		// traver left and right subtree and get the sum of all nodes in left and right
		// subtree and add them to the root value
		int left = calculateTilt(root.left);
		int right = calculateTilt(root.right);

		// calculate the tilt of the current node and add it to the total tilt
		totalTilt += Math.abs(left - right);

		return left + right + root.val;
	}

}