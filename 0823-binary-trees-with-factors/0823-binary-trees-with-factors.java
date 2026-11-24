class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
		Arrays.sort(arr);

		int n = arr.length;
		long[] dp = new long[n];
		Map<Integer, Long> map = new HashMap<>();
		long ans = 0;

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				// if arr i is div arr j we will check if right is prent in map or not
				if (arr[i] % arr[j] == 0) {
					int right = arr[i] / arr[j];
					// if present in map then we will add the value of dp[j] * map.get(right) to
					// dp[i]
					if (map.containsKey(right)) {
						dp[i] += dp[j] * map.get(right);
						dp[i] %= MOD;

					}
				}
			}
			// other wise we will put the value of dp[i] in map with key arr[i]
			map.put(arr[i], dp[i]);
			ans = (ans + dp[i]) % MOD;
		}
		return (int) ans;
    }
}