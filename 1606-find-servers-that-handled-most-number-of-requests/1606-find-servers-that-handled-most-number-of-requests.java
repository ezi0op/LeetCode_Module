class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Min heap : {finishTime, serverIndex}}
		PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

		// available servers sorted by index
		TreeSet<Integer> available = new TreeSet<>();

		// add all k servers to available set
		for (int i = 0; i < k; i++) {
			available.add(i);
		}
		// count requests handled by each server
		int[] count = new int[k];

		for (int i = 0; i < arrival.length; i++) {
			// remove all servers that have completed their requests by the time of
			// arrival[i]
			while (!busyServers.isEmpty() && busyServers.peek()[0] <= arrival[i]) {
				int[] completedServer = busyServers.poll();
				int finishTime = completedServer[0];
				int serverIndex = completedServer[1];
				available.add(serverIndex);
			}
			// if all available servers are busy, we will drop the request
			if (available.isEmpty()) {
				continue;
			}
			// find starting server using modulo operation
			int start = i % k;

			// find next available server
			Integer nextServer = available.ceiling(start);

			// if nextServer is null, it means there is no available server with index >=
			// start, so we will wrap around and take the first available server
			if (nextServer == null) {
				nextServer = available.first();
			}
			// remove the server from available set
			available.remove(nextServer);
			// increase req count
			count[nextServer]++;

			int finishTime = arrival[i] + load[i];

			// add the server to busyServers heap with its finish time
			busyServers.offer(new int[] { finishTime, nextServer });

		}
		// find max count of requests handled by any server
		int maxCount = 0;
		for (int c : count) {
			maxCount = Math.max(maxCount, c);
		}
		// Collect busiest servers with maxCount
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			if (count[i] == maxCount) {
				res.add(i);
			}
		}
		return res;
    }
}