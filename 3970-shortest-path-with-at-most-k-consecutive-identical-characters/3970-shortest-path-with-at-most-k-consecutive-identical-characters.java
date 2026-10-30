class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Creating Adjacency List
		List<int[]>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		// Adding edges to the graph
		// means if edge is from 0 to 1 with weight 2, then graph[0] will have (1,2)
		for (int[] e : edges) {
			graph[e[0]].add(new int[] { e[1], e[2] });
		}

		// Creating a 2D array to store the shortest distance from source to each node
		// with at most k edges
		int[][] dist = new int[n][k + 1];

		for (int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		// Priority Queue to store the nodes to be processed
		// In format of (node, distance, edges used)
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

		// Starting from node 0 with distance 0 and 0 edges used
		dist[0][1] = 0;
		pq.offer(new int[] { 0, 0, 1 });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int node = curr[1];
			int distance = curr[0];
			int edgesUsed = curr[2];
			// Ignoring if we have already found a better path to this node with the same or
			// fewer edges
			if (distance != dist[node][edgesUsed]) {
				continue;
			}
			// Destination node reached
			if (node == n - 1) {
				return distance;
			}

			// Exploring neighbors nodes
			for (int[] neighbor : graph[node]) {
				// here we taking next node and weight of the edge to that node
				int nextNode = neighbor[0];
				int weight = neighbor[1];
				int newCount;

				// check if the character of the current node and next node is same or not
				if (labels.charAt(node) == labels.charAt(nextNode)) {
					newCount = edgesUsed + 1;
					// check for diff character
				} else {
					newCount = 1;
				}

				// check consecutive same character count is less than or equal to k
				if (newCount > k) {
					continue;
				}
				int newCost = distance + weight;

				if (newCost < dist[nextNode][newCount]) {
					dist[nextNode][newCount] = newCost;
					pq.offer(new int[] { newCost, nextNode, newCount });
				}

			}

		}
		return -1;
    }
}