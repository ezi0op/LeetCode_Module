class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
		long k = (long) k1 + k2;
		int[] diff = new int[n];
		int maxDiff = 0;
		long totalDiff = 0;

		// get the diff btw num1 and num2 store diff array and get sum of diff arr and
		// max diff
		for (int i = 0; i < n; i++) {
			diff[i] = Math.abs(nums1[i] - nums2[i]);
			maxDiff = Math.max(maxDiff, diff[i]);
			totalDiff += diff[i];
		}

		// if the total diff is less than or equal to k then we can make all the
		// elements equal and return 0
		if (k >= totalDiff) {
			return 0;
		}

		// find the mini possible max diff by using binary search and then calculate the
		// sum of squares of the diff array
		int left = 0;
		int right = maxDiff;
		while (left < right) {
			int mid = left + (right - left) / 2;
			long needed = 0;
			// find the number of operations needed to make all the elements in the diff
			// array less than or equal to mid
			for (int d : diff) {
				if (d > mid) {
					needed += d - mid;
				}
			}
			// if needed is greater than k then we will search in the left half else we will
			// search in the right half
			if (needed > k) {
				left = mid + 1;

			} else {
				right = mid;
			}

		}
		int target = left;
		long used = 0;
		long ans = 0;

		// reduce every diff greater than target to target and calculate the sum of
		// squares of the diff array
		for (int d : diff) {
			// if the current diff is greater than target then we will reduce it to target
			// and
			if (d > target) {
				used += d - target;
				d = target;
			}
			ans += (long) d * d;
		}
		// get remainig from k and reduce the remaining from the ans
		long remaining = k - used;
		ans -= remaining * (2L * target - 1);
		return ans;

    }
}