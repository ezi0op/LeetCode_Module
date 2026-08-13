class Solution {
    public int[] getConcatenation(int[] nums) {
        	if (nums.length == 0) {
			return new int[0];
		}
		int n = nums.length;
		int ans[] = new int[2 * n];
		for (int i = 0; i < n; i++) {
			ans[i] = nums[i];
			ans[i + n] = nums[i];

		}
		return ans;
    }
}