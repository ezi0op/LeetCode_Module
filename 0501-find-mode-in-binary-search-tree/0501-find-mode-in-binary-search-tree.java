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
    Map<Integer,Integer> map=new HashMap<>();
    public int[] findMode(TreeNode root) {
        
    //Count freq using inorder traversal and store it in map
		inOrderMode(root);
		int max = 0;
		// get max frequency from map
		for (int freq : map.values()) {
			max = Math.max(max, freq);
		}
		List<Integer> list = new ArrayList<>();
		// get all the keys from map whose value is equal to max frequency and add them
		// to the list using entrySet() method of map
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				list.add(entry.getKey());
			}
		}
		int[] ans = new int[list.size()];
		// convert list to array
		for (int i = 0; i < list.size(); i++) {

			ans[i] = list.get(i);
		}
		return ans;
	}

	// helper method to do inorder traversal of the tree and count the frequency of
	// each value
	private void inOrderMode(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderMode(root.left);
		map.put(root.val, map.getOrDefault(root.val, 0) + 1);
		inOrderMode(root.right);

	}

}