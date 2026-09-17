class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        	int n = arr.length;
		int[] minLen = new int[n];
		Arrays.fill(minLen, Integer.MAX_VALUE);

		int left = 0;
		int currSum = 0;
		int minResult = Integer.MAX_VALUE;
		int currMinLen = Integer.MAX_VALUE;

		for (int right = 0; right < n; right++) {
			currSum += arr[right];

			while (currSum > target && left <= right) {
				currSum -= arr[left];
				left++;
			}

			if (currSum == target) {
				int currLen = right - left + 1;
				if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
					minResult = Math.min(minResult, currLen + minLen[left - 1]);
				}
				currMinLen = Math.min(currMinLen, currLen);
			}
			minLen[right] = currMinLen;

		}
		return minResult == Integer.MAX_VALUE ? -1 : minResult;
    }
}