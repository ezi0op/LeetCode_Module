class Solution {
    public int findKthLargest(int[] nums, int k) {
        		Arrays.sort(nums);
		int s = 0;
		int e = nums.length - 1;

		while (s < e) {
			int mid = s + (e - s) / 2;
			
			
			if (nums.length - mid == k) {
				return nums[mid];
			}
			if (nums.length - mid > k) {
				s = mid + 1;
			}
			if (nums.length - mid < k) {
				e = mid - 1;
			}
		}
		return nums[s];
    }
}