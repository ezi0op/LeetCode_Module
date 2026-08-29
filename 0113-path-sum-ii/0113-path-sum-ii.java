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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        	List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		List<Integer> currPath = new ArrayList<>();
		targetSum -= root.val;
		if (root.left == null && root.right == null) {
			if (targetSum == 0) {
				currPath.add(root.val);
				ans.add(new ArrayList<>(currPath));
				currPath.remove(currPath.size() - 1);
			}
			return ans;
		}
		List<List<Integer>> left = pathSum(root.left, targetSum);
		List<List<Integer>> right = pathSum(root.right, targetSum);
		ans.addAll(left);
		ans.addAll(right);
for (List<Integer> path : ans) {
			path.add(0, root.val);
		}
		return ans;
    }
}