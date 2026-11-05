class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        		long count = 0;
		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			// if the current element is less than minK or greater than maxK, we will move
			// the left pointer to the right of the current element
			if (nums[right] < minK || nums[right] > maxK) {
				left = right + 1;
				// if the current element is equal to minK or maxK, we will add the number of
				// subarrays that can be formed with the current element as the rightmost
				// element to the count
			} else {
				count += right - left + 1;

			}
		}
		return count;

    }
}