class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

		List<List<Integer>> children = new ArrayList<>();

		// create a list of children for each node in the tree
		for (int i = 0; i < n; i++) {
			children.add(new ArrayList<>());
		}

		// build the tree using the parent array
		for (int i = 1; i < n; i++) {
			children.get(parent[i]).add(i);
		}

		int[] size = new int[n];
		int[] above = new int[n];
		int[] last = new int[26];

		// fill the size, above and last arrays with -1
		Arrays.fill(last, -1);
		Arrays.fill(above, -1);
		Arrays.fill(size, 1);

		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);

		while (!stack.isEmpty()) {
			int x = stack.pop();
			if (x >= 0) {
				int c = s.charAt(x) - 'a';

				// find the closed matching ancestor of the current node
				above[x] = last[c];

				// update the last occurrence of the current character
				last[c] = x;

				// push the current node back to the stack with a negative value to indicate
				// that we have visited it
				stack.push(~x);

				// push all the children of the current node to the stack
				for (int child : children.get(x)) {
					stack.push(child);
				}

			} else {
				// Exit node
				x = ~x;
				// Exit the node and update the last occurrence of the current character
				int c = s.charAt(x) - 'a';

				// update the last occurrence of the current character to the previous
				// occurrence
				last[c] = above[x];

				if (x > 0) {
					// update the size of the parent node by adding the size of the current node
					int p = (above[x] >= 0) ? above[x] : parent[x];
					size[p] += size[x];
				}

			}
		}
		return size;
    }
}