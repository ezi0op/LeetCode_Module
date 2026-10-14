/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

      	// we using two pointers approach to connect the next pointer of each node to
		// the next right node in a binary tree
		Node curr = root;
		Node dummy = new Node(0);
		while (curr != null) {
			// we using dummy noden to store next level of binary tree as linked list
			Node temp = dummy;
			dummy.next = null;
			while (curr != null) {

				// if left child is not null then connect it to the next pointer of temp and
				// move temp to the next node
				if (curr.left != null) {
					temp.next = curr.left;
					temp = temp.next;
				}
				// if right child is not null then connect it to the next pointer of temp and
				// move temp to the next node
				if (curr.right != null) {
					temp.next = curr.right;
					temp = temp.next;
				}
				// traverse the current level of binary tree using next pointer
				curr = curr.next;
			}
			// move curr to the next level of binary tree using dummy next pointer
			curr = dummy.next;
		}
		return root;
    }

}