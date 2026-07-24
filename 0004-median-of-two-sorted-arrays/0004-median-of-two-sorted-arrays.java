class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
    	int[] merged = new int[nums1.length + nums2.length];

		for (int i = 0; i < nums1.length; i++) {
			merged[i] = nums1[i];
		}
		for (int i = 0; i < nums2.length; i++) {
			merged[nums1.length + i] = nums2[i];
		}

		// sort the merged array using quick sort
		quickSortMedianArr(merged, 0, merged.length - 1);
		int n = merged.length;
		if (n % 2 == 1) {
			return merged[n / 2];
		}

		return (merged[n / 2] + merged[n / 2 - 1]) / 2.0;
	}

	private static void quickSortMedianArr(int[] merged, int i, int j) {
		if (i >= j) {
			return;
		}
		int s = i;
		int e = j;
		int mid = s + (e - s) / 2;
		int pivot = merged[mid];
		while (s <= e) {
			while (merged[s] < pivot) {
				s++;
			}
			while (merged[e] > pivot) {
				e--;
			}
			if (s <= e) {
				int temp = merged[s];
				merged[s] = merged[e];
				merged[e] = temp;
				s++;
				e--;
			}

		}
		quickSortMedianArr(merged, i, e);
		quickSortMedianArr(merged, s, j);

	}
}