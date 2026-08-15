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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
   if (p == null && q == null) {
			return true;
		}

		List<Integer> left = isSameTreeHelper(p);
		List<Integer> right = isSameTreeHelper(q);
		if (left.size() != right.size()) {
			return false;
		}
		for (int i = 0; i < left.size(); i++) {
			if (!Objects.equals(left.get(i),right.get(i))) {
				return false;
			}
		}
		return true;
	


	}

	private List<Integer> isSameTreeHelper(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) {
            ans.add(null);
			return ans;
		}
		ans.add(root.val);
		ans.addAll(isSameTreeHelper(root.left));
		ans.addAll(isSameTreeHelper(root.right));
		return ans;
	}
}