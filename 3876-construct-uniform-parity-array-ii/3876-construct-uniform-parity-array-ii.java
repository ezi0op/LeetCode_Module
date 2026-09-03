class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean allEven = true;
		int min = nums1[0];
		for (int x : nums1) {
			min = Math.min(min, x);
			if ((x & 1) == 1) {

				allEven = false;
			}
		}
		return allEven || (min % 2 == 1);
    }
}