class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
     // min heap to store the k largest elements along with their indices
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			// store num with its index in the priority queue
			pq.offer(new int[] { nums[i], i });
			// keep the size of the priority queue to k by removing the smallest element if
			// the size exceeds k
			if (pq.size() > k) {
				pq.poll();
			}
		}
		// extract the k largest elements from the priority queue and store them in an
		// array along with their indices
		int[][] selected = new int[k][2];

		for (int i = 0; i < k; i++) {
			selected[i] = pq.poll();
		}

		// Reverse original order of selected elements based on their indices
		Arrays.sort(selected, (a, b) -> Integer.compare(a[1], b[1]));
		int[] result = new int[k];
		// fill the result array with the k largest elements in their original order
		for (int i = 0; i < k; i++) {
			result[i] = selected[i][0];
		}
		return result;
   
    }
}