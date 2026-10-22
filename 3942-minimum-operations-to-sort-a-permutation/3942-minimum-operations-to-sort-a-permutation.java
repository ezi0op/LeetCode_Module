class Solution {
    public int minOperations(int[] nums) {
        	int n = nums.length;
		int p = 0;
		// check for index of 0 in the array
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				p = i;
				break;
			}
		}
		boolean inc = true, dec = true;
		for (int i = 0; i < n; i++) {
			// it basically provides next ele in circular manner
			int next = nums[(i + 1) % n];

			// check if next ele is not equal to current element
			if (next != (nums[i] + 1) % n) {
				inc = false;
			}
			// if check if next ele is not equal to current element in reverse order
			if (next != (nums[i] - 1 + n) % n) {
				dec = false;
			}
		}
		int ans = Integer.MAX_VALUE;
		if (inc) {
			ans = Math.min(ans, Math.min(p, n - p + 2));
		}
		if (dec) {
			ans = Math.min(ans, Math.min(p + 2, n - p));
		}
		return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}