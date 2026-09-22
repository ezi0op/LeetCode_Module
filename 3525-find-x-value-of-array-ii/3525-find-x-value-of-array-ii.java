class Solution {
    // here we are creating a node class to store the product of the subarrays with
	// k and the frequency of the product in the count array
	static class Node {
		int prod;
		int[] count;

		Node(int cnt) {
			this.count = new int[cnt];
		}
	}

	static Node[] tree;
	static int n, k;
	static int[] nums;

	public static int[] resultArray(int[] nums, int k, int[][] queries) {

		Solution.nums = nums;
		Solution.k = k;
		Solution.n = nums.length;

		tree = new Node[4 * n];
		build(1, 0, n - 1);

		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int idx = queries[i][0];
			int val = queries[i][1];
			int start = queries[i][2];
			int x = queries[i][3];

			// update the value of nums[idx] to val and update the segment tree
			nums[idx] = val;
			update(1, 0, n - 1, idx, val);

			// get the product of the subarrays with k and increment the frequency of the
			// product
			Node result = query(1, 0, n - 1, start, n - 1);
            ans[i] = result.count[x];
		}
		return ans;

	}

	// here we are querying the segment tree for the product of the subarrays with k
	// and
	// increment the frequency of the product
	private static Node query(int node, int l, int r, int ql, int qr) {

		// if query left is less than or equal to left and right is less than or equal
		// to query right then we will return the node
		if (ql <= l && r <= qr) {
			return tree[node];
		}
		int mid = (l + r) / 2;
		// if query right is less than or equal to mid then we will query the left sub
		// tree
		if (qr <= mid) {
			return query(node * 2, l, mid, ql, qr);
			// else if (ql > mid) then we will query the right sub tree
		} else if (ql > mid) {
			return query(node * 2 + 1, mid + 1, r, ql, qr);
		} else {
			// else we will query both the left and right sub trees and merge the results to
			// get the final result
			Node left = query(node * 2, l, mid, ql, qr);
			Node right = query(node * 2 + 1, mid + 1, r, ql, qr);
			return merge(left, right);
		}

	}

	// here we are updating the value of nums[idx] to val and updating the segment
	// tree
	private static void update(int node, int l, int r, int idx, int val) {
		// if the left and right indices are equal then we will create a new node with
		// the value of k and assign the remainder of the product of the subarrays with
		// k to the prod variable and increment the frequency of the product in the
		// count array
		if (l == r) {
			tree[node] = new Node(k);
			int rem = val % k;
			tree[node].prod = rem;
			tree[node].count[rem] = 1;
			return;
		}
		int mid = (l + r) / 2;
		// if the index is less than or equal to mid then we will update the left sub
		// tree
		// else we will update the right sub tree and then merge the two sub trees to
		// get the final result
		// reason behind doing mid + 1 in right sub tree is to avoid overlapping of the
		// left and right sub trees
		if (idx <= mid) {
			update(node * 2, l, mid, idx, val);
		} else {
			update(node * 2 + 1, mid + 1, r, idx, val);
		}
		tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);

	}

	// here we are building the segment tree for the given array nums and k
	private static void build(int node, int l, int r) {
		// if the left and right indices are equal then we will create a new node with
		// the value of k and assign the remainder of the product of the subarrays with
		// k to the prod variable and increment the frequency of the product in the
		// count array
		if (l == r) {
			// create an node with val of k
			tree[node] = new Node(k);
			// get rem of arr[l] with k and assign it to prod and increment the count of rem
			// in the count array
			int rem = nums[l] % k;

			tree[node].prod = rem;
			tree[node].count[rem] = 1;
			return;
		}
		// get mid
		int mid = (l + r) / 2;
		// first construct left sub tree and then right sub tree and then merge the two
		// sub trees to get the final result
		// reason behind doing mid + 1 in right sub tree is to avoid overlapping of the
		// left and right sub trees
		build(2 * node, l, mid);
		build(2 * node + 1, mid + 1, r);
		tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);

	}

	// here we are merging the left and right sub trees to get the final result
	private static Node merge(Node left, Node right) {
		Node res = new Node(k);
		// product of whole segment is product of left and right segment and take the
		// modulo of k
		res.prod = (left.prod * right.prod) % k;
		// increment the frequency of the product in the count array by adding the
		// frequency of the product in the left and right segments
		for (int x = 0; x < k; x++) {
			res.count[x] += left.count[x];
		}
		// increment the frequency of the product in the count array by adding the
		// frequency of the product in the left and right segments and take the modulo
		// of k
		for (int x = 0; x < k; x++) {
			int newRem = (left.prod * x) % k;
			res.count[newRem] += right.count[x];
		}

		return res;
	}

}