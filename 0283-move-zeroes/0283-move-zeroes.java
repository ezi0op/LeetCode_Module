class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
		int n = 0;
		while (n < nums.length) {
			if (nums[n] != 0) {
				nums[k++] = nums[n];
			}
			n++;
		}
		if (k < nums.length) {
			for (int i = 0; i < nums.length - k; i++) {
				nums[k + i] = 0;
			}
		}
    }
}