class Solution {
    public String[] findRelativeRanks(int[] score) {
        	// sort the scores in descending order and assign ranks to the scores
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		// push the scores and their indices to the priority queue
		for (int i = 0; i < score.length; i++) {
			pq.offer(new int[] { score[i], i });
		}

		String[] res = new String[score.length];
		int count = 0;
		while (!pq.isEmpty()) {
			// remove first element from the priority queue and increment the count
			int[] pair = pq.poll();
			count++;
			// assign the rank to the score based on the count
			if (count == 1) {
				res[pair[1]] = "Gold Medal";

			} else if (count == 2) {
				res[pair[1]] = "Silver Medal";
			} else if (count == 3) {
				res[pair[1]] = "Bronze Medal";
				// if the count is greater than 3, assign the rank as the count
			} else {
				res[pair[1]] = String.valueOf(count);
			}
		}
		return res;
    }
}