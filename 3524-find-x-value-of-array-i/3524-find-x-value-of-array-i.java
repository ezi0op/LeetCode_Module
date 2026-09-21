class Solution {
    public long[] resultArray(int[] nums, int k) {
        	int n = nums.length;
		if (k == 1) {
			return new long[] { (long) n * (n + 1) / 2 };
		}
		long[] ans = new long[k];
		long[] freq = new long[k];
		for (int num : nums) {
			int r = num % k;
			long[] newFreq = new long[k];
			ans[r]++;

			for (int j = 0; j < k; j++) {
				int prod = (j * r) % k;
				newFreq[prod] += freq[j];
				ans[prod] += freq[j];
			}
			newFreq[r]++;
			freq = newFreq;
		}
		return ans;
    }
}