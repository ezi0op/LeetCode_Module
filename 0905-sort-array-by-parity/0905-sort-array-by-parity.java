class Solution {
    public int[] sortArrayByParity(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			if (nums[i] % 2 > nums[j] % 2) {
				swap(nums, i, j);
			}
			if (nums[i] % 2 == 0) {
				i++;
			} else {
				j--;
			}

		}
		return nums;
	}

	static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}