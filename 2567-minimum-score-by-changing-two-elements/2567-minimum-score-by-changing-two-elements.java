class Solution {
    public int minimizeSum(int[] nums) {
     Arrays.sort(nums);

		int n = nums.length;
		int ans = Integer.MAX_VALUE;
		// traverse the array and calculate the difference between the maximum and
		// minimum elements after removing 3 elements from the array. We will keep track
		// of the minimum difference found so far and return it at the end.
		for (int i = 0; i <= 2; i++) {
			// first remove i elements from the start and 2-i elements from the end of the
			// array and calculate the difference between the maximum and minimum elements
			int max = nums[n - 1 - (2 - i)];
			int min = nums[i];
			ans = Math.min(ans, max - min);
		}
		return ans;

    }
}