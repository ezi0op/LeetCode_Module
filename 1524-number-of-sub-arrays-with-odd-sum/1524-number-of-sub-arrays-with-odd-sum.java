class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
		int even = 1, odd = 0;
		int sum = 0;
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];

			// if the cumulative sum is even, we will add the count of odd sums to the
			// result
			if (sum % 2 == 0) {
				count = (count + odd) % MOD;
				even++;
				// if the cumulative sum is odd, we will add the count of even sums to the
				// result
			} else {
				count = (count + even) % MOD;
				odd++;
			}

		}
		return count;
    }
}