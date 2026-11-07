class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        	int m = servers.length;
		int n = tasks.length;

		// Queue to store available servers based on their weight and index by doing
		// sorting them in ascending order of weight and index
		PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0]) {
				return Integer.compare(a[0], b[0]);

			}
			return Integer.compare(a[1], b[1]);
		});

		// Queue to store busy servers based on their available time, weight, and index
		// by
		// sorting them in ascending order of available time, weight, and index
		PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0]) {
				return Long.compare(a[0], b[0]);

			}
			if (a[1] != b[1]) {
				return Long.compare(a[1], b[1]);
			}
			return Long.compare(a[2], b[2]);
		});

		// store server and index
		for (int i = 0; i < m; i++) {
			available.offer(new int[] { servers[i], i });
		}
		int[] ans = new int[n];
		long time = 0;
		for (int j = 0; j < n; j++) {
			// get the current time as the maximum of the current time and the index of the
			// task being processed
			time = Math.max(time, j);
			// while there are busy servers that have completed their tasks by the current
			// time, move them to the available queue
			while (!busy.isEmpty() && busy.peek()[0] <= time) {
				long[] server = busy.poll();
				available.offer(new int[] { (int) server[1], (int) server[2] });
			}
			// if there are available servers, assign the current task to the server with
			// the lowest weight and index, and add the server to the busy queue with its
			// new available time
			if (available.isEmpty()) {
				time = busy.peek()[0];
				// while there are busy servers that have completed their tasks by the current
				while (!busy.isEmpty() && busy.peek()[0] <= time) {
					// poll the server with the earliest available time from the busy queue and add
					// it to the available queue
					long[] server = busy.poll();
					available.offer(new int[] { (int) server[1], (int) server[2] });
				}

			}
			// poll the server with the lowest weight and index from the available queue and
			// assign the current task to it, then add the server to the busy queue with its
			// new available time
			int[] server = available.poll();
			int weight = server[0];
			int index = server[1];
			ans[j] = index;
			busy.offer(new long[] { time + tasks[j], weight, index });
		}
		return ans;


    }
}