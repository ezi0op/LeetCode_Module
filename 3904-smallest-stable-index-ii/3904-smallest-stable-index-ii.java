class Solution {
    public int firstStableIndex(int[] nums, int l) {
       	int n = nums.length;
		int sMin[] = new int[n];
		sMin[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			sMin[i] = Math.min(nums[i], sMin[i + 1]);
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, nums[i]);
			if (max - sMin[i] <= l) {
				return i;
			}
		}
		return -1;
    }
}