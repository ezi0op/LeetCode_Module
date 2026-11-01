class Solution {
   // here we are finding the minimum merged integer from the given array of
	// integers nums
	public  int minMergedInteger(int[] nums) {
		int res = Integer.MAX_VALUE;
		// we jumping here even index for cal
		for (int i = 0; i < nums.length; i += 2) {
			// get val of next index
			int val = nums[i + 1];
			int mul = 10;
			// here the loop is start from val and keep dividing val by 10 until it becomes
			// less than 10, and for each iteration, we multiply mul by 10. This is done to
			// determine the number of digits in val and to calculate the appropriate
			// multiplier for merging nums[i] and val.
			for (int x = val; x >= 10; x /= 10) {
				mul *= 10;
			}
			// here we are calculating the merged integer by multiplying nums[i] with mul
			// and adding val to it. We then update res to be the minimum of res and merged.
			int merged = nums[i] * mul + val;
			res = Math.min(res, merged);
		}
		return res;
	}

}