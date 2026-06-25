class Solution {
    public int[] sortArray(int[] nums) {

		if (nums.length == 1) {
			return nums;
		}

		int mid = nums.length / 2;
		int[] leftArr = sortArray(Arrays.copyOfRange(nums, 0, mid));
		int[] rightArr = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
		return mergeArr(leftArr, rightArr);

	}

	private static int[] mergeArr(int[] leftArr, int[] rightArr) {
		int[] mergedArr = new int[leftArr.length + rightArr.length];
		int i = 0, j = 0, k = 0;

		while (i < leftArr.length && j < rightArr.length) {
			if (leftArr[i] < rightArr[j]) {
				mergedArr[k++] = leftArr[i++];
			} else {
				mergedArr[k++] = rightArr[j++];
			}
		}

		while (i < leftArr.length) {
			mergedArr[k++] = leftArr[i++];
		}
		while (j < rightArr.length) {
			mergedArr[k++] = rightArr[j++];
		}

		return mergedArr;
	}

}