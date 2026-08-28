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
     int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
 return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTreeHelper(int[] preorder, int[] inorder,int left, int right) {
		// if left is greater than right then we will return null
		   if (left > right) {
            return null;
        }
		int rootVal = preorder[preIndex++];
		
		TreeNode root=new TreeNode(rootVal);
		
		int rootIndex = left;
		while(inorder[rootIndex]!=rootVal) {
			rootIndex++;
		}
		root.left=buildTreeHelper(preorder, inorder, left, rootIndex-1);
		root.right=buildTreeHelper(preorder, inorder, rootIndex+1, right);
		
		
	
		return root;
	}
}