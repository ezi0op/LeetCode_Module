class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

		Boolean[] dp = new Boolean[s.length() + 1];
		return wordBreakUtil(0, s, wordDict, dp);

	}

	private static boolean wordBreakUtil(int index, String s, List<String> wordDict, Boolean[] dp) {
		if (index == s.length()) {
			return true;
		}

		if (dp[index] != null) {
			return dp[index];
		}

		for (String word : wordDict) {
			if (s.startsWith(word, index)) {
				if (wordBreakUtil(index + word.length(), s, wordDict, dp)) {
					return dp[index] = true;
				}
			}
		}

		return dp[index] = false;
	}
}