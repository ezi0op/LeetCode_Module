class Solution {
        public int minimumChanges(String s, int k) {
            int n = s.length();
		int INF = 1000000;
		int[][] cost = new int[n][n];
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i + len <= n; i++) {
				int j = i + len - 1;
				cost[i][j] = INF;

				for (int d = 1; d < len; d++) {
					if (len % d != 0) {
						continue;
					}
					int changes = 0;

					for (int offset = 0; offset < d; offset++) {
						int left = i + offset;
						int right = j - (d - 1 - offset);
						while (left < right) {
							if (s.charAt(left) != s.charAt(right)) {
								changes++;
							}
							left += d;
							right -= d;
						}
					}
					cost[i][j] = Math.min(cost[i][j], changes);

				}
			}
		}
		int[][] dp = new int[n + 1][k + 1];
		for (int[] row : dp) {
			Arrays.fill(row, INF);
		}
		dp[0][0] = 0;
		for (int parts = 1; parts <= k; parts++) {
			for (int i = 2 * parts; i <= n; i++) {
				for (int j = 2 * (parts - 1); j <= i - 2; j++) {
					dp[i][parts] = Math.min(dp[i][parts], dp[j][parts - 1] + cost[j][i - 1]);
				}
			}
		}
		return dp[n][k];

        }
}