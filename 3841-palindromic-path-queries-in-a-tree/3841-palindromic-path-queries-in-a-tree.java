class Solution {
   // here LOG is the maximum power of 2 that we will need to store the ancestors
	// of each node
	int LOG;
	// here up is the 2D array where we will store the 2^i th ancestor of each node
	int[][] up;
	// here depth is the depth of the node in the tree, tin is the time when we
	// enter the node and tout is the time when we exit the node
	int[] depth, tin, tout, prefixMask;

	class FenwickNode {
		int node;
		int[] bitMask;

		public FenwickNode(int node) {
			this.node = node;
			this.bitMask = new int[node + 2];
		}

		// XOR delta with the bitmask at index idx
		// means we are toggling the bitmask at index idx with the delta value
		public void updateXORDelta(int idx, int delta) {
			// convert idx to 1 based index
			idx++;
			// while idx is less than or equal to the size of the bitmask
			while (idx <= node + 1) {
				// XOR the delta with the bitmask at index idx
				bitMask[idx] ^= delta;
				// update the index to the next index that we need to update
				// this is done by adding the last set bit of idx to idx
				idx += idx & -idx;
			}
		}

		// Prefix XOR query from 0 to idx
		int queryXOR(int idx) {
			idx++;
			int res = 0;
			// while idx is greater than 0
			while (idx > 0) {
				// XOR the bitmask at index idx with the result
				res ^= bitMask[idx];
				// update the index to the next index that we need to query
				idx -= idx & -idx;
			}
			return res;

		}

		// XOR delta over [left ,right] range
		void rangeDeltaUpdate(int left, int right, int delta) {
			// first traverse left index and update the bitmask with delta
			updateXORDelta(left, delta);
			// then traverse right index and update the bitmask with delta
			updateXORDelta(right + 1, delta);
		}

	}

	public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

		// Build the tree with adjacency list
		// Where adjacency list is a list of lists where each list nodes are connected
		// to the other nodes by level by level
		List<Integer>[] adj = new ArrayList[n];
		// Create n empty lists for each node in the tree
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		// here we are populating the adjacency list with the edges of the tree
		for (int[] edge : edges) {
			// u is the first node of the edge and v is the second node of the edge
			int u = edge[0];
			int v = edge[1];
			// add v to the list of u and u to the list of v
			adj[u].add(v);
			adj[v].add(u);
		}

		// Initialize the FenwickNode with n nodes
		LOG = 1;
		// here we are calculating the maximum power of 2 that we will need to store the
		// ancestors of each node
		while ((1 << LOG) <= n) {
			LOG++;
		}

		// here we are initializing the up, depth, tin, tout and prefixMask arrays with
		// the size of n and LOG
		up = new int[n][LOG];
		depth = new int[n];
		tin = new int[n];
		tout = new int[n];
		prefixMask = new int[n];

		// here we are initializing the euler array with the size of n
		int[] euler = new int[n];

		buildTree(adj, s, euler);

		FenwickNode fenwickNode = new FenwickNode(n);
		char[] charArray = s.toCharArray();

		List<Boolean> result = new ArrayList<>();
		for (String q : queries) {
			String[] parts = q.split(" ");
			if (parts[0].equals("update")) {
				// here we are converting string to integer and character to integer and then
				// calculating the old mask and new mask and then calculating the delta and then
				// updating the fenwick tree with the delta
				int node = Integer.parseInt(parts[1]);
				char newChar = parts[2].charAt(0);
				// get place of the character in the alphabet
				// create a bitmask for the old character and new character
				int oldMask = 1 << (charArray[node] - 'a');

				int newMask = 1 << (newChar - 'a');
				// create an delta mask by XORing the old mask and new mask
				int delta = oldMask ^ newMask;
				// if delta is not 0 then we will update the fenwick tree with the delta
				if (delta != 0) {
					fenwickNode.rangeDeltaUpdate(tin[node], tout[node], delta);
				}
				charArray[node] = newChar;
			} else {

				// these are node idx of fenwick tree
				int u = Integer.parseInt(parts[1]);
				int v = Integer.parseInt(parts[2]);
				// get the lowest common ancestor of u and v
				int lca = getLCA(u, v);

				// get the prefix mask of u and v and lca
				int maskU = prefixMask[u] ^ fenwickNode.queryXOR(tin[u]);
				int maskV = prefixMask[v] ^ fenwickNode.queryXOR(tin[v]);
				int lcaMask = 1 << (charArray[lca] - 'a');
				int pathMask = maskU ^ maskV ^ lcaMask;

				// check if the pathMask has at most one bit set
				result.add((pathMask & (pathMask - 1)) == 0);

			}
		}
		return result;

	}

	// method to get the lowest common ancestor of two nodes u and v
	private int getLCA(int u, int v) {
		// if depth of u is less than depth of v then we will swap u and v
		if (depth[u] < depth[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		// get diff depth of u and v and then we will lift u to the same depth as v
		int diff = depth[u] - depth[v];
		// if the diff is not 0 then we will lift u to the same depth as v
		for (int i = 0; i < LOG; i++) {
			if ((diff & (1 << i)) != 0) {
				u = up[u][i];
			}
		}
		// if u and v are same then we will return u as the lowest common ancestor
		if (u == v) {
			return u;
		}
		// if u and v are not same then we will lift u and v to the same depth and then
		// we will return the parent of u or v as the lowest common ancestor
		for (int i = LOG - 1; i >= 0; i--) {
			if (up[u][i] != up[v][i]) {
				u = up[u][i];
				v = up[v][i];
			}
		}
		return up[u][0];

	}

	private void buildTree(List<Integer>[] adj, String s, int[] euler) {
		int n = adj.length;
		char[] charArray = s.toCharArray();

		// here we are initializing the parent array with the size of n and filling it
		// with -1
		int[] parent = new int[n];
		Arrays.fill(parent, -1);

		// here we are initializing the nextChild and nextSibling arrays with the size
		// of n
		int[] nextChild = new int[n];
		int[] stack = new int[n];
		int top = 0;
		int time = 0;
		stack[top++] = 0;
		parent[0] = 0;
		boolean[] visited = new boolean[n];

		// here we are doing a DFS traversal of the tree and populating the tin, tout,
		// depth, prefixMask and up arrays
		while (top > 0) {
			int u = stack[top - 1];

			if (!visited[u]) {
				visited[u] = true;
				// if nextChild[u] is 0 then we will set the tout[u] to time and increment time
				tin[u] = time;
				euler[time++] = u;
				// create charmask for the character at index u in the string s
				int charMask = 1 << (charArray[u] - 'a');
				// if u is the root node then we will set the prefixMask[u] to charMask else we
				// will set the prefixMask[u] to prefixMask[parent[u]] XOR charMask
				if (u == 0) {
					prefixMask[u] = charMask;
				} else {
					prefixMask[u] = prefixMask[parent[u]] ^ charMask;
				}
				// assign first index of up[u] to parent[u] and then for each k from 1 to LOG-1
				// we will assign up[u][k] to up[up[u][k-1]][k-1]
				up[u][0] = parent[u];
				for (int k = 1; k < LOG; k++) {
					up[u][k] = up[up[u][k - 1]][k - 1];
				}

			}

			// if nextChild[u] is less than the size of the adjacency list of u then we will
			// get the next child v of u and if v is not the parent of u then we will set
			// the parent of v to u and set the depth of v to depth of u + 1 and increment
			// nextChild[u] else we will set the tout[u] to time - 1 and decrement top
			if (nextChild[u] < adj[u].size()) {
				// get the next child v of u
				int v = adj[u].get(nextChild[u]++);
				// if v is the parent of u then we will continue to the next iteration of the
				// loop
				if (v == parent[u]) {
					continue;
				}
				// set the parent of v to u and set the depth of v to depth of u + 1 and
				// increment nextChild[u]
				parent[v] = u;
				depth[v] = depth[u] + 1;
				stack[top++] = v;
			} else {
				// if nextChild[u] is equal to the size of the adjacency list of u then we will
				tout[u] = time - 1;
				top--;
			}

		}

	}

}