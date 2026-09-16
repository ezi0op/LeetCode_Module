class Solution {
    public int numberOfSets(int n, int k) {
        
    	long Mod = 1_000_000_007;

		long[][] dp = new long[n + 1][k + 1];
		long[][] prefix = new long[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
			prefix[i][0] = i + 1;
		}

		for (int r = 1; r < n; r++) {
			for (int c = 1; c <= k; c++) {
				dp[r][c] = dp[r - 1][c];
				dp[r][c] += prefix[r - 1][c - 1];
				dp[r][c] %= Mod;
				prefix[r][c] = (prefix[r - 1][c] + dp[r][c]) % Mod;
			}
		}

		return (int) dp[n - 1][k];
	}
 
}