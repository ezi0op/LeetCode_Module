class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        	int n = nums.length;

		Deque<Integer> deque = new ArrayDeque<>();
		long cost = 0, ans = 0;
		int left = n - 1;
		for (int right = n - 1; right >= 0; right--) {
			// while the deque is not empty and the last element in the deque is less than
			// the current element, we will remove the last element from the deque and
			// update the cost accordingly
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
				int l = deque.pollLast();
				int r = deque.isEmpty() ? left + 1 : deque.peekLast();
				cost += (long) (r - l) * (nums[right] - nums[l]);
			}
			deque.offerLast(right);
			// if cost is greater than k then we will move the left pointer to the left and
			// update the cost accordingly
			while (cost > k) {
				// get diff btw the current element and the leftmost element in the deque and
				// subtract it from the cost
				cost -= nums[deque.peekFirst()] - nums[left];
				// if the leftmost element in the deque is equal to the left pointer then we
				// will remove it from the deque
				if (deque.peekFirst() == left) {
					deque.pollFirst();
				}
				// dec the left pointer
				left--;
			}
			// add the number of non-decreasing subarrays that can be formed with the
			// current
			ans += left - right + 1;
		}
		return ans;
    }
}