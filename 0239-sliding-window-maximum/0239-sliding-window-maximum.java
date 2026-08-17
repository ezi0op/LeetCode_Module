class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      if (nums.length == 0) {
			return new int[0];
		}
		
		int[] ans = new int[nums.length - k + 1];
		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < nums.length; i++) {

			while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
				queue.pollFirst();
			}
			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.pollLast();
			}
			queue.offerLast(i);
			if (i >= k - 1) {
				ans[i - k + 1] = nums[queue.peekFirst()];
			}

		}
		return ans;
    }

}