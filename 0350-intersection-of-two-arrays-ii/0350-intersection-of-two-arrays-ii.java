class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
		int n = nums2.length;
		int i = 0, j = 0, k = 0;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		while (i < m && j < n) {
			// check if nums1 is less nums 2 if then inc first array index
			if (nums1[i] < nums2[j]) {
				i++;
				// check if nums1 is greater than nums2 if then increment scond array index
			} else if (nums1[i] > nums2[j]) {
				j++;
				// if nums1 is equal to nums2 then add it to the result array and inc i and j
			} else {
				nums1[k++] = nums1[i++];
				j++;
			}
		}
		//return range of nums1 from 0 to k as the result array
		return Arrays.copyOfRange(nums1, 0, k);
    }
}