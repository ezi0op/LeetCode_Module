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
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
   	maxPathSumHelper(root);
		return ans;

	}

	private int maxPathSumHelper(TreeNode root) {

		if (root == null) {
			return 0;
		}
		int left = Math.max(0, maxPathSumHelper(root.left));
		int right = Math.max(0, maxPathSumHelper(root.right));
		int currMax = left + right + root.val;
		ans = Math.max(ans, currMax);
		return root.val + Math.max(left, right);

	}     
    
}