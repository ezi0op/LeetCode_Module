class Solution {
   
    public int distinctSubseqII(String s) {
   int n = s.length();
		long mod = 1000000007;
		int[] dp = new int[n + 1];
		dp[0] = 1;

		int[] last = new int[26];
		Arrays.fill(last, -1);

		for (int i = 1; i <= n; i++) {
			dp[i] = (int) ((2 * dp[i - 1]) % mod);
			int charIdx = s.charAt(i - 1) - 'a';
			if (last[charIdx] != -1) {
				dp[i] = (int) ((dp[i] - dp[last[charIdx]] + mod) % mod);
			}
			last[charIdx] = i - 1;
		}
		return (dp[n] - 1 + (int) mod) % (int) mod;
	} 
}