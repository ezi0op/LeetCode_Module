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
    	int dfsAns = 0;
	int maxDepth = -1;
    public int findBottomLeftValue(TreeNode root) {
  findBottomLeftValueDFSHelper(root, 0);
		return dfsAns;
	}

	private void findBottomLeftValueDFSHelper(TreeNode root, int i) {
		if (root == null) {
			return;
		}
		if (i > maxDepth) {
			maxDepth = i;
			dfsAns = root.val;
		}
		findBottomLeftValueDFSHelper(root.left, i + 1);
		findBottomLeftValueDFSHelper(root.right, i + 1);

	}
}