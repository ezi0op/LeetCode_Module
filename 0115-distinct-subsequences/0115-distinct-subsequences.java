class Solution {
    public int numDistinct(String s, String t) {
     		int[][] dp = new int[s.length() + 1][t.length() + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return numDistinctUtil(s, t, 0, 0, dp);

	}

	private static int numDistinctUtil(String s, String t, int i, int j, int[][] dp) {

		if (j == t.length()) {
			return 1;
		}
		if (i == s.length()) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (s.charAt(i) == t.charAt(j)) {
			int take = numDistinctUtil(s, t, i + 1, j + 1, dp);
			int skip = numDistinctUtil(s, t, i + 1, j, dp);
			return dp[i][j] = take + skip;
		}

		return dp[i][j] = numDistinctUtil(s, t, i + 1, j, dp);
	}
}