class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
		Arrays.sort(nums2);
		int s1 = 0;
		int s2 = 0;

		int[] ans = new int[Math.min(nums1.length, nums2.length)];
		int k = 0;
		while (s1 < nums1.length && s2 < nums2.length) {
			if (nums1[s1] == nums2[s2]) {
				if (k == 0 || ans[k - 1] != nums1[s1]) {
					ans[k++] = nums1[s1];
				}
				s1++;
				s2++;

			} else if (nums1[s1] < nums2[s2]) {
				s1++;

			} else {
				s2++;

			}
		}
		return Arrays.copyOf(ans, k);
    }
}