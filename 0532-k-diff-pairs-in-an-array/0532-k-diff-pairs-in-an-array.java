class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
			return 0;
		}
		Arrays.sort(nums);
		int s = 0;
		int e = 1;
		int count = 0;

		while (e < nums.length) {

			if (nums[e] - nums[s] > k) {
				s++;

			} else if (s == e || nums[e] - nums[s] < k) {

				e++;
			} else {

				count++;
				s++;
				e++;
				while (e < nums.length && nums[e] == nums[e - 1]) {
					e++;
				}
			}
		}

		return count;
    }
}